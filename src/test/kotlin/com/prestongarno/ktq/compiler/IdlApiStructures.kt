package com.prestongarno.ktq.compiler

import com.prestongarno.ktq.indent
import org.junit.Test

class IdlApiStructures {

  @Test fun `this thing work first shot?`() {
    val mockSchema = """
      type Foo {
        name: String
        inputField(value: Int): String
      }
    """.trimIndent()
    val compilation = GraphQLCompiler(StringSchema(mockSchema))
    compilation.compile()

    compilation.definitions.size eq 1
    compilation.definitions.first().apply {

      name eq "Foo"
      this as TypeDef
      supertypes.size eq 0
      fields.size eq 2

      fields.find { it.name == "name" }?.apply {
        name eq "name"
        type === StringType
      } ?: null!!

      fields.find { it.name == "inputField" }?.apply {
        name eq "inputField"
        type eq StringType
        arguments.size eq 1
        nullable eq true
        isList eq false

        arguments.first().apply {
          name eq "value"
          type eq IntType
          nullable eq true
          isList eq false
        }
      } ?: null!!
    }
  }

  @Test fun `incorrect field arg name fails`() {
    val mockSchema = """
      |
      |interface Bar {
      |  name(val1: Int!): String
      |}
      |
      |interface Baz {
      |  name(val1: Int!): String
      |}
      |
      |type Foo implements Bar, Baz {
      |  name(val0: Int!): String
      |}
      |
      """.trimMargin("|")

    assertThrows<IllegalArgumentException> {
      GraphQLCompiler(StringSchema(mockSchema)).compile()
    }.hasMessageThat()
        .contains("interface not the same as concrete")
  }

  @Test fun `nullable differences fails`() {
    val mockSchema = """
      |
      |interface Bar {
      |  name(val1: Int): String
      |}
      |
      |interface Baz {
      |  name(val1: Int!): String
      |}
      |
      |type Foo implements Bar, Baz {
      |  name(val1: Int!): String
      |}
      |
      """.trimMargin("|")

    // TODO failing!
    assertThrows<IllegalArgumentException> {
      GraphQLCompiler(StringSchema(mockSchema)).compile()
    }
  }

  @Test fun `multiple inheritance on fields`() {
    val mockSchema = """
      |
      |interface Bar {
      |  name(val1: Int!): String
      |}
      |
      |interface Baz {
      |  name(val1: Int!): String
      |}
      |
      |type Foo implements Bar, Baz {
      |  name(val1: Int!): String
      |}
      |
      """.trimMargin("|")
    val compilation = GraphQLCompiler(StringSchema(mockSchema))
    compilation.compile()
    compilation.definitions.find { it.name == "Foo" }?.apply {
      this as TypeDef
      supertypes.size eq 2
      compilation.definitions.filterNot {
        this === it
      }.let { withoutThis ->
        require(supertypes.containsAll(withoutThis))
      }
      fields.size eq 1
      fields.first().apply {
        name eq "name"
        type eq StringType
        typeName eq "String"
        arguments.size eq 1
        arguments.first().apply {
          name eq "val1"
          type eq IntType
          typeName eq "Int"
          inheritsFrom.size eq 2
          true eq inheritsFrom.filterNot {
            it.name == "Bar" || it.name == "Baz"
          }.isEmpty()
        }
      }
    }?: null!!
  }
}


fun GraphQLCompiler.prettyPrintScopes(): String {
  return definitions.filterIsInstance<ScopedDeclarationType<*>>().joinToString("\n") {
    it.name + it.symtab.entries.joinToString(prefix = "\n", separator = ",\n") {
      it.value.let {
        "${it.name}(${it.arguments.joinToString(", ") {
          it.name + ": " + it.typeName.let { name ->
            if (it.isList) "[$name]" else name
          }.let { name ->
            if (!it.nullable) name + "!" else name
          }
        }}): ${it.typeName}"
      }
    }.indent(1)
  }

}

private fun String.print() = println(this)