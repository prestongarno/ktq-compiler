package com.prestongarno.ktq.compiler

import com.prestongarno.ktq.org.antlr4.gen.GraphQLSchemaBaseListener
import com.prestongarno.ktq.org.antlr4.gen.GraphQLSchemaLexer
import com.prestongarno.ktq.org.antlr4.gen.GraphQLSchemaParser
import org.antlr.v4.runtime.CharStreams
import org.junit.Test
import org.antlr.v4.runtime.CommonTokenStream

class AntlrAstParsing {

  @Test fun simpleImplements() {
    val input = CharStreams.fromString("""

      type RandomMutation {
        accept(input: Baz): Baz
      }

      interface Foo {
        name: String
      }

      union BarOrBaz = Bar | Baz

      type Bar implements Foo {
        name: String
      }

      scalar Hello

    """.trimIndent())
    val lexer = GraphQLSchemaLexer(input)
    val stream = CommonTokenStream(lexer)
    val parser = GraphQLSchemaParser(stream)
    parser.graphqlSchema().children.forEachIndexed {index, parseTree ->
      println(parseTree.toStringTree(parser))
    }
  }
}


