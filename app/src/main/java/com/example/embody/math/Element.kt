package com.example.embody.math

data class Element(val set: Set<Int>, val order: Int) {
    override fun toString(): String {
        return "{${set.joinToString()}}"
    }
}