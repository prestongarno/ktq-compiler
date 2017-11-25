package com.prestongarno.ktq.compiler.javac

import com.google.common.io.Files
import com.prestongarno.ktq.compiler.GraphQLCompiler
import com.prestongarno.ktq.compiler.JvmCompile
import com.prestongarno.ktq.compiler.KtqCompileWrapper
import com.prestongarno.ktq.compiler.compileGraphQl
import com.prestongarno.ktq.compiler.compileOut
import com.prestongarno.ktq.compiler.toFileSpec
import org.junit.After
import java.io.File

open class JavacTest {

  private var compileClassLoader: KtqCompileWrapper? = null

  @After fun tearDown() { compileClassLoader?.delete() }

  protected fun toClassloader(schema: String, block: GraphQLCompiler.() -> Unit = {  }): KtqCompileWrapper =
      JvmCompile.exe(
          compileGraphQl(schema, block)
        .toFileSpec()
        .toJavaFileObject().name.let(::File),
          Files.createTempDir()
              .apply(File::deleteOnExit),
          System.out
      )
}
