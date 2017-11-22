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
  }

}