package com.example.embody.graphics

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import kotlin.math.cos
import kotlin.math.sin

internal fun DrawScope.drawNecklace(
    center: Point,
    radius: Float,
    values: List<Boolean>
) {
    val numCircles = values.size

    drawCircle(
        color = Color.Black,
        radius = 10f,
        center = Offset(center.x, center.y),
        alpha = 1f
    )

    for (index in (0 until numCircles)) {
        val angle = index / numCircles.toFloat() * 2f * Math.PI - Math.PI / 2 // radians
        val x = center.x + cos(angle).toFloat() * radius
        val y = center.y + sin(angle).toFloat() * radius

        drawCircle(
            color = Color.Black,
            radius = radius / 4,
            center = Offset(x, y),
            alpha = if (values[index]) 1.0f else 0.5f
        )
    }
}