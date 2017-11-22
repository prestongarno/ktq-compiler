package com.prestongarno.ktq.compiler

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
      }?: null!!

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
      }?: null!!
    }
  }

}