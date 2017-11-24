package com.prestongarno.ktq.compiler

import com.google.common.truth.ThrowableSubject
import com.google.common.truth.Truth.assertThat
import com.squareup.kotlinpoet.FileSpec
import java.time.Instant
import java.util.*

inline fun <reified T> assertThrows(block: () -> Unit): ThrowableSubject {
  try {
    block()
  } catch (e: Throwable) {
    if (e is T) {
      return assertThat(e)
    } else {
      throw e
    }
  }
  throw AssertionError("Expected ${T::class.simpleName}")
}

fun compileGraphQl(schema: String, block: (GraphQLCompiler.() -> Unit)? = null) =
    GraphQLCompiler(StringSchema(schema)).apply {
      compile()
      block?.invoke(this)
    }.definitions

fun compileOut(schema: String, includeImports: Boolean = true, block: (GraphQLCompiler.() -> Unit)? = null): String =
    compileGraphQl(schema, block).toFileSpec().let {
      val target = StringBuilder()
      it.writeTo(target)
      target.toString() // smh kotlinpoet
          .let {
            if (includeImports) it else
              it.replace("^import.*\n".toRegex(RegexOption.MULTILINE), "")
                  .replace("^package.*\n".toRegex(RegexOption.MULTILINE), "")
                  .replace("^\n\n", "")
          }
    }

private fun Set<SchemaType<*>>.toFileSpec(): FileSpec =
    FileSpec.builder("com.prestongarno.ktq.compiler",
        "TestCompile${Date.from(Instant.now())}.kt").apply {
      map(SchemaType<*>::toKotlin)
          .forEach { this.addType(it) }
    }.build()

// Not a test case without functional printlines
fun String.println() = println(this)

