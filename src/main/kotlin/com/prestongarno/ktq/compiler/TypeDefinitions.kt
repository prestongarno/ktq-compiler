package com.prestongarno.ktq.compiler

import com.prestongarno.ktq.org.antlr4.gen.GraphQLSchemaParser
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import org.antlr.v4.runtime.ParserRuleContext

sealed class SchemaType<out T : ParserRuleContext>(val context: T) : KotlinTypeElement, NamedElement

sealed class ScopedDeclarationType<out T : ParserRuleContext>(context: T) : SchemaType<T>(context) {
  abstract val fields: Set<FieldDefinition>

  val symtab by lazy {
    fields.map { it.name to it }.toMap()
  }
}

class TypeDef(context: GraphQLSchemaParser.TypeDefContext)
  : ScopedDeclarationType<GraphQLSchemaParser.TypeDefContext>(context) {

  override val name: String = context.typeName().Name().text

  override val fields = context.fieldDef().map { FieldDefinition(it) }.toSet()

  lateinit var supertypes: Set<InterfaceDef>

  override fun toKotlin(): TypeSpec = TypeSpec.objectBuilder(name).apply {
    addProperties(fields.map { it.toKotlin() })
    addSuperinterfaces(supertypes.map { it.name.asTypeName() })
  }.build()
}

class InterfaceDef(context: GraphQLSchemaParser.InterfaceDefContext)
  : ScopedDeclarationType<GraphQLSchemaParser.InterfaceDefContext>(context) {

  override val name: String = context.typeName().Name().text

  override val fields = context.fieldDef().map(::FieldDefinition).toSet()

  override fun toKotlin(): TypeSpec = TypeSpec.interfaceBuilder(name).apply {
    addProperties(fields.map {
      it.toKotlin()
    })
  }.build()
}

class UnionDef(context: GraphQLSchemaParser.UnionDefContext)
  : SchemaType<GraphQLSchemaParser.UnionDefContext>(context) {

  override val name: String = context.typeName().Name().text

  lateinit var possibilities: Set<TypeDef>

  override fun toKotlin(): TypeSpec = TypeSpec.objectBuilder(name).apply {
    addSuperinterface("QUnionType".asTypeName()) // TODO use submodule of my branch for class delegation
    possibilities.map { type ->

      FunSpec.builder("on" + type.name[0].toUpperCase() + type.name.let {
        if (it.length > 1) it.substring(1) else ""
      }).apply {
        // ugly java calling code wtf
        addParameter(ParameterSpec.builder("init",
            LambdaTypeName.get(returnType = ParameterizedTypeName.get(ClassName.bestGuess("QModel"),
                type.name.asTypeName()))).build())
        addCode("on(init)")
      }.build()

    }.forEach {
      addFunction(it)
    }

  }.build()
}

class ScalarDef(context: GraphQLSchemaParser.ScalarDefContext)
  : SchemaType<GraphQLSchemaParser.ScalarDefContext>(context) {

  override val name = context.typeName().Name().text

  override fun toKotlin(): TypeSpec = TypeSpec.objectBuilder(name).build()
}

class EnumDef(context: GraphQLSchemaParser.EnumDefContext)
  : SchemaType<GraphQLSchemaParser.EnumDefContext>(context) {

  override val name: String = context.typeName().Name().text

  val options = context.scalarName().map { it.Name().text }

  override fun toKotlin(): TypeSpec = TypeSpec.enumBuilder(name).apply {
    options.forEach { addEnumConstant(it) }
    addSuperinterface("QEnumType".asTypeName())
  }.build()

}

class InputDef(context: GraphQLSchemaParser.InputTypeDefContext)
  : ScopedDeclarationType<GraphQLSchemaParser.InputTypeDefContext>(context) {

  override val name = context.typeName().Name().text

  override val fields = context.fieldDef().map(::FieldDefinition).toSet()

  override fun toKotlin(): TypeSpec = TypeSpec.classBuilder(name).apply {
    // add required (non-nullable) fields to primary constructor
    this@InputDef.fields.filterNot { it.nullable }.map { required ->
      ParameterSpec.builder(required.name, required.type.name.asTypeName()).build()
    }.also { params ->
      FunSpec.constructorBuilder()
          .addParameters(params)
          .build()
          .let(this::primaryConstructor)
    }
    // add others as nullable props
    this@InputDef.fields.filter { it.nullable }.map {
      PropertySpec.builder(it.name, it.type.name.asTypeName().asNullable())
          .initializer("null") // TODO boxed primitives
          .build()
    }.let(this::addProperties)

  }.build()

}

sealed class ScalarType : SchemaType<PlatformTypeContext>(PlatformTypeContext)

object IntType : ScalarType() {
  override val name: String get() = "Int"
  override fun toKotlin(): TypeSpec = throw UnsupportedOperationException()
}

object StringType : ScalarType() {
  override val name: String get() = "String"
  override fun toKotlin(): TypeSpec = throw UnsupportedOperationException()
}

object FloatType : ScalarType() {
  override val name: String get() = "Float"
  override fun toKotlin(): TypeSpec = throw UnsupportedOperationException()
}

object BooleanType : ScalarType() {
  override val name: String get() = "Boolean"
  override fun toKotlin(): TypeSpec = throw UnsupportedOperationException()
}

object PlatformTypeContext : ParserRuleContext()

fun String.asTypeName(): TypeName = ClassName.bestGuess(this)

