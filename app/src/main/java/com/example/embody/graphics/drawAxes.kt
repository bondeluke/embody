package com.example.embody.graphics

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

internal fun DrawScope.drawAxes() {
    drawLine( // x-axis
        start = Offset(x = 0f, y = size.height / 2),
        end = Offset(x = size.width, y = size.height / 2),
        color = Color.Gray
    )
    drawLine( // y-axis
        start = Offset(x = size.width / 2, y = 0f),
        end = Offset(x = size.width / 2, y = size.height),
        color = Color.Gray
    )
}