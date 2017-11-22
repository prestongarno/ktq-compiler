package com.prestongarno.ktq.compiler

import com.prestongarno.ktq.org.antlr4.gen.GraphQLSchemaParser
import com.squareup.kotlinpoet.TypeSpec
import org.antlr.v4.runtime.ParserRuleContext

sealed class SchemaType<out T : ParserRuleContext>(val context: T) : KotlinTypeElement, NamedElement

sealed class ScopedDeclarationType<out T : ParserRuleContext>(context: T) : SchemaType<T>(context) {
  abstract val fields: Set<FieldDefinition>
}

class TypeDef(context: GraphQLSchemaParser.TypeDefContext)
  : ScopedDeclarationType<GraphQLSchemaParser.TypeDefContext>(context) {

  override val name: String = context.typeName().Name().text

  override val fields = context.fieldDef().map {
    FieldDefinition(it)
  }.toSet()

  lateinit var supertypes: Set<InterfaceDef>

  override fun toKotlin(): TypeSpec {
    TODO()
  }
}

class InterfaceDef(context: GraphQLSchemaParser.InterfaceDefContext)
  : ScopedDeclarationType<GraphQLSchemaParser.InterfaceDefContext>(context) {

  override val name: String = context.typeName().Name().text

  override val fields = context.fieldDef().map {
    FieldDefinition(it)
  }.toSet()

  override fun toKotlin(): TypeSpec {
    TODO("Not Implemented")
  }
}

class UnionDef(context: GraphQLSchemaParser.UnionDefContext)
  : SchemaType<GraphQLSchemaParser.UnionDefContext>(context) {

  override val name: String = context.typeName().Name().text

  val possibleTypes = context.unionTypes().typeName().map { it.Name().text }

  override fun toKotlin(): TypeSpec {
    TODO("Not Implemented")
  }
}

class ScalarDef(context: GraphQLSchemaParser.ScalarDefContext)
  : SchemaType<GraphQLSchemaParser.ScalarDefContext>(context) {

  override val name = context.typeName().Name().text

  override fun toKotlin(): TypeSpec {
    TODO("Not Implemented")
  }
}

class EnumDef(context: GraphQLSchemaParser.EnumDefContext)
  : SchemaType<GraphQLSchemaParser.EnumDefContext>(context) {

  override val name: String = context.typeName().Name().text

  val options = context.scalarName().map { it.Name().text }

  override fun toKotlin(): TypeSpec {
    TODO("Not Implemented")
  }
}

class InputDef(context: GraphQLSchemaParser.InputTypeDefContext)
  : ScopedDeclarationType<GraphQLSchemaParser.InputTypeDefContext>(context) {

  override val name = context.typeName().Name().text

  override val fields = context.fieldDef().map {
    FieldDefinition(it)
  }.toSet()

  override fun toKotlin(): TypeSpec {
    TODO("Not Implemented")
  }

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
