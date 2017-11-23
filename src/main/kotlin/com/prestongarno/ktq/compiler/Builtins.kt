package com.prestongarno.ktq.compiler

enum class ScalarPrimitives(val typeDef: ScalarType) {
  INT(IntType),
  BOOLEAN(BooleanType),
  FLOAT(FloatType),
  STRING(StringType);

  companion object {
    val normalized: Map<String, ScalarPrimitives> = values().map { Pair(it.name, it) }.toMap()
  }
}

