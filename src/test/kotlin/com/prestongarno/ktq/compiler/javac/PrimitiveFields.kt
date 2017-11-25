package com.prestongarno.ktq.compiler.javac

import org.junit.Test

class PrimitiveFields : JavacTest() {

  @Test fun `single integer field compiles`() {
    val source = toClassloader("""
      |type Definition {
      |  value: Int
      |}
      """.trimMargin("|"))
        .loadObject("Definition").apply {
      println(this@apply::class.members)
    }

  }
}