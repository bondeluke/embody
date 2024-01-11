package com.example.embody.math

data class Element(
    val seed: Int,
    val set: Set<Int>
) {
    override fun toString(): String {
        return "{${set.joinToString()}}"
    }
}