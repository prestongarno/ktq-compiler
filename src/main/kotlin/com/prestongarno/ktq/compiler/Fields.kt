package com.prestongarno.ktq.compiler

import com.prestongarno.ktq.input.QInput
import com.prestongarno.ktq.org.antlr4.gen.GraphQLSchemaParser
import com.prestongarno.ktq.stubs.CustomScalarListStub
import com.prestongarno.ktq.stubs.CustomScalarStub
import com.prestongarno.ktq.stubs.EnumListStub
import com.prestongarno.ktq.stubs.EnumStub
import com.prestongarno.ktq.stubs.InterfaceListStub
import com.prestongarno.ktq.stubs.InterfaceStub
import com.prestongarno.ktq.stubs.TypeListStub
import com.prestongarno.ktq.stubs.TypeStub
import com.prestongarno.ktq.stubs.UnionListStub
import com.prestongarno.ktq.stubs.UnionStub
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asClassName
import kotlin.reflect.KClass

sealed class ScopedSymbol : SymbolElement {
  abstract val nullable: Boolean
  abstract val isList: Boolean
  abstract var type: SchemaType<*>
}

data class FieldDefinition(val context: GraphQLSchemaParser.FieldDefContext) : ScopedSymbol(), KotlinPropertyElement {

  override val name = context.fieldName().Name().text

  override val typeName = context.typeSpec().typeName().text

  override val nullable = context.typeSpec().nullable() == null

  override val isList = context.typeSpec().listType() != null

  override lateinit var type: SchemaType<*>

  var isAbstract: Boolean = false

  lateinit var inheritsFrom: Set<InterfaceDef>

  /** has to be done from an outside context. Created in [GraphQLCompiler.attrInheritance]*/
  internal var argBuilder: ArgBuilderDef? = null

  val arguments: List<ArgumentDefinition> = context.fieldArgs()
      ?.argument()
      ?.map(::ArgumentDefinition)
      ?: emptyList()

  override fun toKotlin(): PropertySpec =
      PropertySpec.builder(name, ktqGraphQLDelegateKotlinpoetTypeName()).build()

  /**
   * [ StubType ].[ Query<T> | OptionalConfigQuery<T, A> | ConfigurableQuery<T, A> ]
   * StubType: [ [String|Float|Int|Boolean]{Array}Delegate | [Type|Interface|Union|Enum|CustomScalar]{List}Stub ]
   *
   * Primitive delegates/stubs don't have a type argument.
   * Only for the the associated ArgBuilder class on the graphql primitive field
   */
  private fun ktqGraphQLDelegateKotlinpoetTypeName(): TypeName {

    fun FieldDefinition.configurationTypeClassName(): String = when {
      arguments.isEmpty() -> "Query"
      arguments.isNotEmpty() && arguments.find { it.nullable == false } == null -> "OptionalConfigQuery"
      else -> "ConfigurableQuery"
    }

    fun `type name for non-collection field`() = when (type) {
      is EnumDef -> EnumStub::class
      is InterfaceDef -> InterfaceStub::class
      is ScalarDef -> CustomScalarStub::class
      is InputDef -> QInput::class
      is TypeDef -> TypeStub::class
      is UnionDef -> UnionStub::class
      is ScalarType -> ScalarPrimitives.normalized[type.name]!!.typeDef.stubClass
      else -> throw IllegalStateException()
    }

    fun `type name for list field`() = when (type) {
      is EnumDef -> EnumListStub::class
      is InterfaceDef -> InterfaceListStub::class
      is ScalarDef -> CustomScalarListStub::class
      is InputDef -> QInput::class
      is TypeDef -> TypeListStub::class
      is UnionDef -> UnionListStub::class
      else -> throw IllegalStateException()
    }
    // determine the base type of delegate/stub that this
    // property will be based off of the type and the arguments
    val baseTypeName = (if (isList) `type name for list field`() else `type name for non-collection field`())
        .asClassName()
        .nestedClass(configurationTypeClassName())

    fun FieldDefinition.argBuilderTypeName(): TypeName {
      require(arguments.isNotEmpty())
      return ClassName.bestGuess(argBuilder!!.context.name)
          .nestedClass(argBuilder!!.name)
    }

    // When scalar/primitive type -> no type arg,
    val parameterizedTypeNames: List<TypeName> = mutableListOf<TypeName>().apply {
      if (type !is ScalarType) add(name.asTypeName())
      if (arguments.isNotEmpty()) add(argBuilderTypeName())
    }

    return if (type is ScalarType && arguments.isEmpty()) baseTypeName else ParameterizedTypeName.get(
        ClassName(baseTypeName.packageName(), baseTypeName.simpleName()),
        *parameterizedTypeNames.toTypedArray()
    )
  }

}

data class ArgumentDefinition(val context: GraphQLSchemaParser.ArgumentContext) : ScopedSymbol(), KotlinParameterElement {

  override val name: String get() = context.Name().text

  override val typeName: String get() = context.typeSpec().typeName().text

  override val nullable = context.typeSpec().nullable() == null

  override val isList = context.typeSpec().listType() != null

  override lateinit var type: SchemaType<*>

  override fun toKotlin(): ParameterSpec {
    val type = if (isList)
      ParameterizedTypeName.get(List::class.asClassName(), typeName.asTypeName())
    else typeName.asTypeName()

    return ParameterSpec.builder(name, type.apply {
      if (nullable) asNullable()
    }).build()
  }

  override fun equals(other: Any?): Boolean {
    return other === this || (other as? ArgumentDefinition)?.let {
      name == it.name
          && typeName == it.typeName
          && nullable == it.nullable
          && isList == it.isList
    } ?: return false
  }
}

internal class ArgBuilderDef(val field: FieldDefinition, val context: ScopedDeclarationType<*>) {

  val isInterface = field.isAbstract

  val name = (if (isInterface) "Base" else "") +
      field.name[0].toUpperCase() +
      (if (field.name.length > 1) field.name.substring(1) else "") + "Args"
}

