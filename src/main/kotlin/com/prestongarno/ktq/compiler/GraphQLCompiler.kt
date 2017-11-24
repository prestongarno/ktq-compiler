package com.prestongarno.ktq.compiler

import com.prestongarno.ktq.org.antlr4.gen.GraphQLSchemaLexer
import com.prestongarno.ktq.org.antlr4.gen.GraphQLSchemaParser
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import java.io.File
import java.util.*
import kotlin.properties.Delegates

typealias SchemaRule = Set<SchemaType<*>>.() -> Unit
typealias SymbolScopeRule = Set<ScopedSymbol>.(ScopedDeclarationType<*>) -> Unit

/** TODO use antlr4's listener hooks to stop unnecessary iteration for validation rules */
class GraphQLCompiler(
    private val schema: Schema,
    private val scope: Configuration.() -> Unit = { /* nothing */ }
) {

  /** This is kept in sync by the [GraphQLCompiler.definitions] variable. Do NOT add definitions here */
  internal val symtab: MutableMap<String, SchemaType<*>> = ScalarPrimitives.values().map {
    it.typeDef.name to it.typeDef
  }.toMap(mutableMapOf())

  internal val definitions: MutableSet<SchemaType<*>> by Delegates.observable(mutableSetOf()) { _, _, newValue ->
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
      `no duplicate symbol names`()
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

    parser.addErrorListener(MessageHandler())

    val result = parser.graphqlSchema()

    // Add type definitions to context
    definitions += result.enumDef().map { EnumDef(it) }
    definitions += result.inputTypeDef().map { InputDef(it) }
    definitions += result.interfaceDef().map { InterfaceDef(it) }
    definitions += result.typeDef().map { TypeDef(it) }
    definitions += result.scalarDef().map { ScalarDef(it) }
    definitions += result.unionDef().map { UnionDef(it) }
    symtab.putAll(definitions.map { it.name to it })

    // processing & intermediate type structure
    attrInheritance()
    attrFieldTypes()
    attrUnions()

    schemaRules.onEach { it(definitions) }
    inspectFields(*scopedSymbolRules.toTypedArray())
  }


  private fun attrFieldTypes() {

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

  private fun attrUnions() {
    fun UnionDef.setLateinitPossibilities(defs: Set<TypeDef>) {
      possibilities = defs
    }

    definitions.on<UnionDef> {

      context.unionTypes().typeName().map {
        it.Name().text
      }.map {
        symtab[it] as TypeDef // safe cast - rule will prevent this
      }.also { options ->
        this.setLateinitPossibilities(options.toSet())
      }
    }
  }


  /**
   * Apply validation to a set of symbols within the same scope */
  private fun inspectFields(vararg rules: SymbolScopeRule) {
    definitions.on<ScopedDeclarationType<*>> {
      rules.forEach { rule -> rule(fields, this@on) }
    }
  }

  class Configuration private constructor(val schema: Schema) {
    // todo compilation options here for gradle build config
    companion object {
      internal fun fromContext(schema: Schema, scope: Configuration.() -> Unit): Configuration =
          Configuration(schema).apply(scope)
    }
  }
}

/** Require each type has a different name */
private fun `duplicate type names check`(): SchemaRule = {
  // TODO is this really that inefficient? Github schema is 300+ definitions....
  forEach { defn -> require(count { it.name == defn.name } == 1) }
}

private fun `type name does not match scalar primitive`(): SchemaRule = {
  forEach { defn ->
    require(ScalarPrimitives.normalized[defn.name] == null) {
      "Illegal schema declaration name '${defn.name}' at" + defn.context.sourceInterval.a
    }
  }
}

private fun `unique supertype declarations`(): SchemaRule = {
  on<TypeDef> {
    require(supertypes.distinct().size == supertypes.size) {
      "Illegal supertype declaration at type $name (duplicate declaration)"
    }
  }
}

/** Require each symbol name to be unique within its enclosing scope */
private fun `no duplicate symbol names`(): SymbolScopeRule = {
  forEach { symbol ->
    require(count { it.name == symbol.name } == 1)
  }
}

private fun Token.toCoordinates() = "[${this.line},${this.startIndex}]"

fun <T> List<T>.applyEach(scope: T.() -> Unit) = forEach(scope)

inline fun <reified T> Collection<*>.on(action: T.() -> Unit) = this?.filterIsInstance<T>()?.forEach(action)

private class MessageHandler : ANTLRErrorListener {
      override fun reportAttemptingFullContext(
          recognizer: Parser?,
          dfa: DFA?,
          startIndex: Int,
          stopIndex: Int,
          conflictingAlts: BitSet?,
          configs: ATNConfigSet?
      ) {}

      override fun syntaxError(
          recognizer: Recognizer<*, *>?,
          offendingSymbol: Any?,
          line: Int,
          charPositionInLine: Int,
          msg: String?,
          e: RecognitionException?
      ) { TODO(msg?:"") }

      override fun reportAmbiguity(
          recognizer: Parser?,
          dfa: DFA?,
          startIndex: Int,
          stopIndex: Int,
          exact: Boolean,
          ambigAlts: BitSet?,
          configs: ATNConfigSet?
      ) { /* nothing */ }

      override fun reportContextSensitivity(
          recognizer: Parser?,
          dfa: DFA?,
          startIndex: Int,
          stopIndex: Int,
          prediction: Int,
          configs: ATNConfigSet?
      ) { /* nothing */ }
    }