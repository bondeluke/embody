package com.example.embody.math.sets

fun allBinarySequences(size: Int): List<List<Boolean>> {
    return if (size == 1) listOf(listOf(true), listOf(false))
    else allBinarySequences(size - 1).let { result ->
        result.map { listOf(true) + it } + result.map { listOf(false) + it }
    }
}
