package com.example.embody

import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.TextMeasurer
import com.example.embody.graphics.Point
import com.example.embody.math.necklace.getNecklaces

internal fun DrawScope.drawNecklaces(seed: Int, textMeasurer: TextMeasurer) {
    val necklaces = getNecklaces(seed).groupBy { it.relationships.size }
    val numRows = necklaces.size
    val padding = (size.height / numRows) / 5
    for (row in 0..<necklaces.size) {
        val rowNecklaces = necklaces[row]
        val numColumns = rowNecklaces!!.size
        for (col in rowNecklaces.indices) {
            val x = getRatioBasedOnIndex(col, numColumns)
            val y = getRatioBasedOnIndex(row, numRows)
            drawNecklace(
                necklace = rowNecklaces[col],
                center = Point(x * size.width, y * size.height),
                radius = size.height / (numRows * 2) - padding,
                textMeasurer = textMeasurer
            )
        }
    }
}


fun getRatioBasedOnIndex(index: Int, total: Int): Float {
    return (index.toFloat() / total + 1f / (total * 2f))
}