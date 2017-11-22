package com.prestongarno.ktq.compiler

import org.junit.Test

class IdlApiStructures {

  @Test fun `this thing work first shot?`() {
    val mockSchema = """
      type Foo {
        name: String
      }
    """.trimIndent()
    val compilation = GraphQLCompiler(StringSchema(mockSchema))
    compilation.compile()
    compilation.definitions.size eq 1
    compilation.definitions.first().apply {
      name eq "Foo"
      this as TypeDef
      supertypes.size eq 0
      fields.size eq 1
      fields.first().apply {
        name eq "name"
        type === StringType
      }
    }
  }

}