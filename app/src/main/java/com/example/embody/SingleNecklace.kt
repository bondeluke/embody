package com.example.embody

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
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

    Canvas(modifier) {
        val necklace = getNecklaces(seed)
            .filter { it.relationships.size == seed }
            .random()

        drawNecklace(
            necklace = necklace,
            center = Point(size.width / 2, size.height / 2),
            radius = size.width / 3,
            textMeasurer = textMeasurer,
            showCount = false,
            showAddition = false
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SingleNecklacePreview() {
    EmbodyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = RGB(245, 255, 250).toColor()
        ) {
            SingleNecklace(12)
        }
    }
}
