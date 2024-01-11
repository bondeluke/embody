package com.example.embody.math.necklace

import com.example.embody.math.Element

fun Element.getCanonicalIntervalSetOrdering(): List<Int> {
    if (set.isEmpty()) return emptyList()

    val sorted = set.toList().sorted()
    return (0 until sorted.size - 1).map {
        sorted[it + 1] - sorted[it]
    }.plus(seed + sorted.first() - sorted.last())
        .let { getCanonicalIntervalSetOrdering(seed, it) }
}