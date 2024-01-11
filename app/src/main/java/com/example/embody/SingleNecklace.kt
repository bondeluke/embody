package com.example.embody

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import com.example.embody.graphics.Point
import com.example.embody.graphics.RGB
import com.example.embody.math.necklace.getNecklaces
import com.example.embody.ui.theme.EmbodyTheme

@Composable
fun SingleNecklace(seed: Int, modifier: Modifier = Modifier) {
    val textMeasurer = rememberTextMeasurer()

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(RGB(235, 255, 245).toColor())
    ) {
//        drawAxes()

        val necklace = getNecklaces(seed).filter { it.relationships.size == seed }.random()

        drawNecklace(
            necklace = necklace,
            center = Point(size.width / 2, size.height / 2),
            radius = size.width / 3,
            textMeasurer = textMeasurer
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SingleNecklacePreview() {
    EmbodyTheme {
        SingleNecklace(12)
    }
}