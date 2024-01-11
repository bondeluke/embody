package com.example.embody

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.rememberTextMeasurer

@Composable
fun Necklaces(seed: Int, modifier: Modifier = Modifier) {
    val textMeasurer = rememberTextMeasurer()

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
//        drawAxes()
        drawNecklaces(seed, textMeasurer)
    }
}