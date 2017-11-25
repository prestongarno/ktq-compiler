package com.prestongarno.ktq.compiler

import com.google.common.io.Files
import com.prestongarno.ktq.QSchemaType
import org.jetbrains.kotlin.cli.common.arguments.K2JVMCompilerArguments
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.cli.common.messages.MessageRenderer
import org.jetbrains.kotlin.cli.common.messages.PrintingMessageCollector
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler
import org.jetbrains.kotlin.config.Services
import org.jetbrains.kotlin.incremental.isJavaFile
import java.io.File
import java.io.PrintStream
import java.net.URL
import java.net.URLClassLoader
import java.time.Instant
import kotlin.reflect.KClass

object JvmCompile {

  fun fromString(input: String): KtqCompileWrapper {
    val kotlinOut = File.createTempFile("Kotlinpoet${Instant.now().toEpochMilli()}", ".kt")
        .apply(File::deleteOnExit)
    kotlinOut.writeText(input)
    return exe(kotlinOut, Files.createTempDir()
        .apply(File::deleteOnExit))
  }

  @JvmOverloads
  fun exe(input: File, buildDir: File, printStream: PrintStream? = null): KtqCompileWrapper {
    K2JVMCompiler().run {
      val args = K2JVMCompilerArguments().apply {
        freeArgs = mutableListOf(input.absolutePath)
        loadBuiltInsFromDependencies = true
        includeRuntime = false
        noOptimize = true
        singleModule = true
        destination = buildDir.absolutePath
        classpath = System.getProperty("java.class.path")
            .split(System.getProperty("path.separator"))
            .filter {
              it.asFile().exists() && it.asFile().canRead()
            }.joinToString(":")
        noStdlib = true
        noReflect = true
        skipRuntimeVersionCheck = true
        reportPerf = true
      }
      buildDir.deleteOnExit()
      // TODO -> Compilation services for stubbing classes without output et. al. black magic
      // TODO -> Services.Builder().register(interfaceClass = TODO(), implementation = TODO())
      execImpl(printStream?.let {
        PrintingMessageCollector(it, MessageRenderer.PLAIN_RELATIVE_PATHS, true)
      } ?:MessageCollector.NONE, Services.EMPTY, args)
    }.code.also { exitCode -> require(exitCode == 0) }
    return KtqCompileWrapper(buildDir)
  }

}

fun File.getFileTree(): List<File> {
  return this.walkTopDown().asSequence().distinct()
      .filter { it.isFile }
      .toList()
}

class KtqCompileWrapper(private val root: File) {

  val loader = URLClassLoader(
      listOf(root.toURI().toURL()).toTypedArray(),
      this::class.java.classLoader)

  @Suppress("UNCHECKED_CAST") fun loadObject(name: String): QSchemaType =
      (loader.loadClass(name).kotlin as KClass<QSchemaType>).objectInstance!!

  @Suppress("UNCHECKED_CAST") fun loadInterface(name: String): KClass<QSchemaType> =
      (loader.loadClass(name).kotlin as KClass<QSchemaType>)

  fun delete() = Unit ?:
      loader.urLs.map(URL::toURI)
      .map(::File)
      .map(File::walkBottomUp)
      .flatMap(FileTreeWalk::asIterable)
      .filter(File::isJavaFile)
      .filter(File::canWrite)
      .forEach(File::deleteOnExit)
}

fun String.asFile() = File(this)
