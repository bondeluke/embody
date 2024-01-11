package com.example.embody.math.necklace

import com.example.embody.math.Element
import com.example.embody.math.sets.subsets

fun getNecklaces(seed: Int): List<Necklace> {
    return seed.subsets()
        .map { Element(seed, it) }
        .sortedBy { it.set.size }
        .groupBy { it.getCanonicalIntervalSetOrdering() }
        .map { Necklace(seed, it.key, it.value) }
}