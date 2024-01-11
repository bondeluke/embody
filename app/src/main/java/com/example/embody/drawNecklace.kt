package com.example.embody

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.embody.graphics.HSV
import com.example.embody.graphics.Point
import com.example.embody.math.necklace.Necklace
import com.example.embody.ui.theme.EmbodyTheme
import kotlin.math.cos
import kotlin.math.sin

internal fun DrawScope.drawNecklace(
    necklace: Necklace,
    center: Point,
    radius: Float,
    textMeasurer: TextMeasurer,
) {
    val values = getElements(necklace)

    val numCircles = necklace.seed

    val measuredCenterText =
        textMeasurer.measure(
            AnnotatedString(necklace.elements.size.toString()),
            style = TextStyle(fontSize = 25.sp)
        )

    drawText(
        textLayoutResult = measuredCenterText,
        topLeft = Offset(
            center.x - measuredCenterText.size.width / 2f,
            center.y - measuredCenterText.size.height / 2f
        )
    )

    val measuredUnderText =
        textMeasurer.measure(
            AnnotatedString(necklace.toAdditionString()),
            style = TextStyle(fontSize = 13.sp)
        )

    drawText(
        textLayoutResult = measuredUnderText,
        topLeft = Offset(
            center.x - measuredUnderText.size.width / 2f,
            center.y + radius + measuredUnderText.size.height / 1.8f
        )
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
            color = getColorFromIndex(index, numCircles),
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

private fun getColorFromIndex(index: Int, numCircles: Int): Color {
    return HSV(
        hue = ((numCircles - index).toFloat() * 360f / numCircles.toFloat() + 53) % 360,
        sat = 0.6f,
        value = 0.88f
    ).toRGB().toColor()
}

fun getElements(necklace: Necklace): List<Boolean> {
    val elements = mutableListOf<Boolean>()

    for (i in 0..<necklace.seed)
        elements.add(false)

    var counter = 0
    for (element in necklace.relationships) {
        counter = counter + necklace.seed - element
        counter %= necklace.seed
        elements[counter] = true
    }

    return elements
}

@Preview(showBackground = true)
@Composable
fun NecklacePreview() {
    EmbodyTheme {
        Necklaces(8)
    }
}