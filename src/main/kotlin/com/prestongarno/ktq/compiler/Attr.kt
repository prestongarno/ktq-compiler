package com.prestongarno.ktq.compiler

import com.prestongarno.ktq.org.antlr4.gen.GraphQLSchemaParser
import com.prestongarno.ktq.org.antlr4.gen.GraphQLSchemaParser.*

/**
 * If a concrete type definition contains a field which both:
 *
 *   A) Overrides >1 superinterface declaration
 *   B) Changes input argument count
 *
 * Bounds for generic args on non-primitive delegates & stubs will be incorrect
 *
 * Strategy for entering field inheritance info for kotlinpoet generic args on fields:
 *   1. enter supertypes to type
 *   2.   cache names from super to concrete type
 *   3. enter fields
 *   4.   get values from local scoped cache
 *   5.   validate
 *   6.   create type info
 */
internal fun GraphQLCompiler.attrInheritance() {
  definitions.on<TypeDef> {
    // create a table for fields->supertype(s)
    val fieldSuperTable = fields
        .map(FieldDefinition::newCache)
        .toMap(mutableMapOf())

    context.implementationDefs()
        ?.typeName()
        ?.map(TypeNameContext::toNameString)
        ?.map(this@attrInheritance::fromSymtab)
        ?.onEach { supertype ->
          supertype.fields
              .map(this::joiningWithImplementation)
              .onEach(this::checkConsistency)
              .map(::second)
              .map(supertype::registerAsSuper)
              .forEach(fieldSuperTable::cacheSymbol)
        }?.toSet()
        ?.let(this@on::setSupertypes)
        ?: setSupertypes(emptySet())

    fields.onEach(fieldSuperTable::setFieldInheritanceContext)
        .onEach(this::assignArgBuilder)
  }
}


/** get the supertype from schema type symbol table */
private fun GraphQLCompiler.fromSymtab(sym: String): InterfaceDef {
  val superTypeDef = symtab[sym] ?: throw IllegalArgumentException("Unknown supertype name $sym on type declaration")
  return superTypeDef as? InterfaceDef ?: throw IllegalArgumentException("Supertype declaration '$sym' is not an interface type!")
}

/** explicit lateinit property access */
private fun TypeDef.setSupertypes(def: Set<InterfaceDef>) {
  this.supertypes = def
}

private fun TypeDef.joiningWithImplementation(abstractField: FieldDefinition): Pair<FieldDefinition, FieldDefinition> {
  val concrete = symtab[abstractField.name] ?: throw IllegalArgumentException("Type ${name} does not override abstract " +
      "graphql field ${abstractField.name} declared in ${supertypes.flatMap(InterfaceDef::fields).find {
        it.name == abstractField.name
      }?.name}")
  return abstractField to concrete
}

/** @throws IllegalArgumentException if the GraphQL field and arguments don't match the interface's specification */
private fun TypeDef.checkConsistency(properties: Pair<FieldDefinition, FieldDefinition>) {
  properties.also { (abstract, concrete) ->
    require(abstract.isAbstract && !concrete.isAbstract)
    require(abstract.arguments.size <= concrete.arguments.size
        && concrete.arguments.filter { cArg ->
      abstract.arguments.find {
        cArg.name != it.name
            || cArg.isList != it.isList
            || cArg.typeName != it.typeName
      } != null
    }.isEmpty()) {
      abstract.arguments.find { it in concrete.arguments == false }?.let {
        "Argument ${it.name} on interface not the same as concrete type '$name' field ${concrete.name}"
      } ?: ""
    }
  }

}

private fun second(pair: Pair<FieldDefinition, FieldDefinition>): FieldDefinition = pair.second

private fun InterfaceDef.registerAsSuper(field: FieldDefinition): Pair<FieldDefinition, InterfaceDef> = field to this

private fun MutableMap<FieldDefinition, MutableSet<InterfaceDef>>.cacheSymbol(pair: Pair<FieldDefinition, InterfaceDef>) {
  this[pair.first] = this[pair.first]?.apply { add(pair.second) } ?: mutableSetOf(pair.second)
}

private fun MutableMap<FieldDefinition, MutableSet<InterfaceDef>>.setFieldInheritanceContext(field: FieldDefinition) {
  field.inheritsFrom = this[field]?.toSet() ?: emptySet()
}

private fun FieldDefinition.setSupertypes(supers: Set<InterfaceDef>?) {
  this.inheritsFrom = supers ?: emptySet()
}

private fun GraphQLSchemaParser.TypeNameContext.toNameString(): String = Name().text

private fun FieldDefinition.newCache(): Pair<FieldDefinition, MutableSet<InterfaceDef>> = this to mutableSetOf()

private fun TypeDef.assignArgBuilder(field: FieldDefinition) {
  if (field.arguments.isNotEmpty()) field.argBuilder = ArgBuilderDef(field, this)
}
