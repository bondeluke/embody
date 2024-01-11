package com.example.embody.math.necklace

import kotlin.math.pow

fun getCanonicalIntervalSetOrdering(seed: Int, intervalSet: List<Int>): List<Int> {
    return (intervalSet.indices).map {
        intervalSet.takeLast(intervalSet.size - it) + intervalSet.take(it)
    }.maxByOrNull {
        it.foldIndexed(1F) { index, acc, value ->
            seed.toFloat().pow(intervalSet.size - index - 1) * value + acc
        }
    } ?: throw Exception("The interval set $intervalSet did not have a maximum.")
}