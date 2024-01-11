package com.example.embody.graphics

import androidx.compose.ui.graphics.Color

data class RGB(val red: Int, val green: Int, val blue: Int) {
    fun toColor(): Color {
        return Color(red, green, blue)
    }
}