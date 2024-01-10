package com.example.embody.math.necklace

data class Necklace(val elements: List<Int>, val order: Int) {
    override fun toString(): String {
        return "(${elements.joinToString()})"
    }
}

