package com.example.embody.graphics

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

internal fun DrawScope.drawNecklace(
    cofCenter: Point,
    cofRadius: Float,
    values: List<Boolean>,
    cr: Int = 20
) {
    val numCircles = values.size

    for (index in (0 until numCircles)) {
        val angle = index / numCircles.toFloat() * 2f * Math.PI - Math.PI / 2 // radians
        val x = cofCenter.x + cos(angle).toFloat() * cofRadius
        val y = cofCenter.y + sin(angle).toFloat() * cofRadius

        drawCircle(
            color = Color.Black,
            radius = cr.dp.toPx(),
            center = Offset(x, y),
            alpha = if (values[index]) 1.0f else 0.5f
        )
    }
}