package com.example.embody.math.necklace

import com.example.embody.math.Element

data class Necklace(
    val seed: Int,
    val relationships: List<Int>,
    val elements: List<Element>
) {
    override fun toString(): String {
        return "(${relationships.joinToString()})"
    }

    fun toAdditionString(): String {
        return relationships.joinToString(" + ")
    }
}

