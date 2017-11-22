package com.prestongarno.ktq.compiler

import com.prestongarno.ktq.org.antlr4.gen.GraphQLSchemaParser
import com.squareup.kotlinpoet.PropertySpec

sealed class ScopedSymbol : KotlinPropertyElement, SymbolElement {
  abstract val nullable: Boolean
  abstract val isList: Boolean
  abstract var type: SchemaType<*>
}

class FieldDefinition(val context: GraphQLSchemaParser.FieldDefContext): ScopedSymbol() {

  override val name = context.fieldName().Name().text

  override val typeName = context.typeSpec().typeName().text

  override val nullable = context.typeSpec().nullable() == null

  override val isList = context.typeSpec().listType() != null

  override lateinit var type: SchemaType<*>

  val arguments: List<ArgumentDefinition> = context.fieldArgs()?.argument()?.map {
    ArgumentDefinition(it)
  }?: emptyList()

  override fun toKotlin(): PropertySpec {
    TODO("Not Implemented")
  }

}

class ArgumentDefinition(val context: GraphQLSchemaParser.ArgumentContext): ScopedSymbol() {

  override val name: String get() = context.Name().text

  override val typeName: String get() = context.typeSpec().typeName().text

  override val nullable = context.typeSpec().nullable() == null

  override val isList = context.typeSpec().listType() != null

  override lateinit var type: SchemaType<*>

  override fun toKotlin(): PropertySpec {
    TODO("Not Implemented")
  }
}
