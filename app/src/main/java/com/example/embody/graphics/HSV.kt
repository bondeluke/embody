package com.example.embody.graphics

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

data class HSV(val hue: Float, val sat: Float, val value: Float) {
    fun toRGB(): RGB {
        val hsv = FloatArray(3)
        hsv[0] = hue
        hsv[1] = sat
        hsv[2] = value
        return android.graphics.Color.HSVToColor(hsv).let {
            RGB(it.red, it.green, it.blue)
        }
    }
}