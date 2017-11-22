package com.prestongarno.ktq.compiler

import com.prestongarno.ktq.org.antlr4.gen.GraphQLSchemaLexer
import com.prestongarno.ktq.org.antlr4.gen.GraphQLSchemaParser
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Token
import java.io.File
import kotlin.properties.Delegates

typealias SchemaRule = Set<SchemaType<*>>.() -> Unit
typealias SymbolScopeRule = Set<ScopedSymbol>.(ScopedDeclarationType<*>) -> Unit

/**
 * TODO use antlr4's listener hooks to stop unnecessary iteration for validation rules */
class GraphQLCompiler(private val schema: Schema, private val scope: Configuration.() -> Unit = { /* nothing */ }) {

  /** This is kept in sync by the [GraphQLCompiler.definitions] variable. Do NOT add definitions here */
  private val symtab: MutableMap<String, SchemaType<*>> = ScalarPrimitives.values().map {
    Pair(it.typeDef.name, it.typeDef)
  }.toMap(mutableMapOf())

  private val definitions: MutableSet<SchemaType<*>> by Delegates.observable(
      ScalarPrimitives.values().map {
        it.typeDef as SchemaType<*>
      }.toMutableSet()
  ) { _, _, newValue ->
    newValue.filter { symtab[it.name] == null }.forEach { defn ->
      symtab[defn.name] = defn
    }
  }

  private val schemaRules = listOf<SchemaRule>(
      `duplicate type names check`(),
      `unique supertype declarations`(),
      `type name does not match scalar primitive`()
  )

  private val scopedSymbolRules = listOf<SymbolScopeRule>(
      `no duplicate symbol names`(),
      `check supertype property inheritance`()
  )

  fun compile() {

    val config = Configuration.fromContext(schema, scope)

    // Get schema
    val input: CharStream = when (config.schema) {
      is StringSchema -> CharStreams.fromString(config.schema.source)
      is FileSchema -> CharStreams.fromPath(File(config.schema.path).toPath())
    }

    // Parse/lexify it
    val lexer = GraphQLSchemaLexer(input)
    val stream = CommonTokenStream(lexer)
    val parser = GraphQLSchemaParser(stream)
    val result = parser.graphqlSchema()

    // Add type definitions to context
    result.apply {
      definitions += enumDef().map { EnumDef(it) }
      definitions += inputTypeDef().map { InputDef(it) }
      definitions += interfaceDef().map { InterfaceDef(it) }
      definitions += typeDef().map { TypeDef(it) }
      definitions += scalarDef().map { ScalarDef(it) }
      definitions += unionDef().map { UnionDef(it) }
    }

    attrInheritance()
    attrFields()

    schemaRules.forEach { it(definitions) }

    inspectFields(*scopedSymbolRules.toTypedArray())
  }

  /**
   * assign type definitions to fields & arguments */
  private fun attrInheritance() {

    fun TypeDef.setSupertypes(def: Set<InterfaceDef>) {
      this.supertypes = def
    }
    // partition definitions by instance/type
    val filtered = Types(definitions)
    // map interfaces as supertypes to types
    filtered.types.forEach { type ->
      // map supertype names to types from symbol table
      type.context.implementationDefs()?.typeName()?.map {
        it.Name().text
      }?.map { superName ->
        // todo split up this spaghetti
        (symtab[superName] as? InterfaceDef ?: throw IllegalArgumentException(
            "Supertype declaration $superName on type ${type.name} is not an interface type!"
        )) ?: throw IllegalArgumentException(
            "Unknown supertype name $superName on type declaration ${type.name}"
        )
      }?.toSet()?.let { supers ->
        type.setSupertypes(supers)
      } ?: type.setSupertypes(emptySet())
    }
  }

  private fun attrFields() {

    fun FieldDefinition.setType(type: SchemaType<*>) {
      this.type = type
    }
    // get all types with fields
    val contextTypes = definitions.filterIsInstance<ScopedDeclarationType<*>>()
    // map field type name to type instance
    contextTypes.flatMap { it.fields }.asSequence().forEach { field ->
      val typeName = field.context.typeSpec().typeName().Name().text
      symtab[typeName]?.let { type ->
        field.setType(type)
      } ?: throw IllegalArgumentException(
          "Unknown type attr for field ${field.name} '$typeName' at ${field.context.start.toCoordinates()}")
    }
    // map arguments' type names to type instance TODO nest this ^^^
    contextTypes.flatMap { it.fields.flatMap { it.arguments } }.forEach { argument ->
      argument.type = symtab[argument.context.typeSpec().typeName().Name().text]
          ?: throw IllegalArgumentException(
          "Unknown type attr for argument ${argument.name} at ${argument.context.start.toCoordinates()}")
    }
  }

  /**
   * Apply validation to a set of symbols within the same scope */
  private fun inspectFields(vararg rules: SymbolScopeRule) {
    definitions.filterIsInstance<ScopedDeclarationType<*>>().forEach {
      rules.forEach { rule -> rule(it.fields, it) }
    }
  }

  private class Types(schemaDefs: Set<SchemaType<*>>) {
    val types = schemaDefs.filterIsInstance<TypeDef>()
    val enums = schemaDefs.filterIsInstance<EnumDef>()
    val unions = schemaDefs.filterIsInstance<UnionDef>()
    val interfaces = schemaDefs.filterIsInstance<InterfaceDef>()
    val scalars = schemaDefs.filterIsInstance<ScalarDef>()
    val inputs = schemaDefs.filterIsInstance<InputDef>()
  }

  /**
   * Kotlin DSL for no reason other than "why not?" */
  class Configuration private constructor(val schema: Schema) {

    companion object {

      internal fun fromContext(schema: Schema, scope: Configuration.() -> Unit): Configuration {
        return Configuration(schema).apply {
          this.scope()

        }
      }

    }
  }
}

/** Require each type has a different name */
fun `duplicate type names check`(): SchemaRule = {
  // TODO is this really that inefficient? Github schema is 300+ definitions....
  forEach { defn -> require(count { it.name == defn.name } == 1) }
}

fun `type name does not match scalar primitive`(): SchemaRule = {
  forEach { defn ->
    require(ScalarPrimitives.normalized[defn.name] == null) {
      "Illegal schema declaration name '${defn.name}' at" + defn.context.sourceInterval.a
    }
  }
}

fun `unique supertype declarations`(): SchemaRule = {
  filterIsInstance<TypeDef>().forEach { type ->
    require(type.supertypes.distinct().size == type.supertypes.size) {
      "Illegal supertype declaration at type ${type.name} (duplicate declaration)"
    }
  }
}

/** Require each symbol name to be unique within its enclosing scope */
fun `no duplicate symbol names`(): SymbolScopeRule = {
  forEach { symbol ->
    require(count { it.name == symbol.name } == 1)
  }
}

fun `check supertype property inheritance`(): SymbolScopeRule = { declarationType ->
  if (declarationType is TypeDef) {
    // TODO(diamond problem)
  }
}

private fun Token.toCoordinates() = "[${this.line},${this.startIndex}]"