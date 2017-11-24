package com.prestongarno.ktq.compiler

import org.junit.Test

class ToKotlin {

  // yay!
  @Test fun `simple type to kotlin`() {
    val mockSchema = """
      |
      |type User {
      |  name: String
      |}
    """.trimMargin("|")

    compileOut(mockSchema) eq """
      |object User : QType {
      |  val name: StringDelegate.Query by QSchemaType.QScalar.String.stub()
      |}
      |""".trimMargin("|")
  }

}

