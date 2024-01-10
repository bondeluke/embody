package com.example.embody.math.necklace

import com.example.embody.math.Element
import com.example.embody.math.sets.subsets

fun getNecklaces(seed: Int): Map<Necklace, List<Element>> {
        val elements = seed.subsets()
            .map { Element(it, seed) }
            .sortedBy { it.set.size }

        return elements.groupBy { it.toNecklace() }
}