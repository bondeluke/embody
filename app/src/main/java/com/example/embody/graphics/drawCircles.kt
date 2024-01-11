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
        radius = 6f,
        center = Offset(center.x, center.y),
        alpha = 1f
    )

    for (index in (0 until numCircles)) {
        val p1 = getPointFromIndex(index, numCircles, center, radius)
        val p2 = getPointFromIndex(index + 1, numCircles, center, radius)

        drawLine(
            start = Offset(x = p1.x, y = p1.y),
            end = Offset(x = p2.x, y = p2.y),
            color = Color.Black
        )
    }

    for (index in (0 until numCircles)) {
        val p1 = getPointFromIndex(index, numCircles, center, radius)
        val x = p1.x
        val y = p1.y

        drawCircle(
            color = Color.Black,
            radius = radius / 4,
            center = Offset(x, y),
            alpha = 1.0f
        )
        if (!values[index]) {
            drawCircle(
                color = Color.White,
                radius = radius / 4 - 2,
                center = Offset(x, y),
                alpha = 1.0f
            )
        }
    }
}

private fun getPointFromIndex(index: Int, numCircles: Int, center: Point, radius: Float): Point {
    val angle = index / numCircles.toFloat() * 2f * Math.PI - Math.PI / 2 // radians
    return Point(
        x = center.x + cos(angle).toFloat() * radius,
        y = center.y + sin(angle).toFloat() * radius
    )
}