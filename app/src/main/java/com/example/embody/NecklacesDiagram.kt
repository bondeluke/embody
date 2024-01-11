package com.example.embody

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import com.example.embody.graphics.RGB
import com.example.embody.ui.theme.EmbodyTheme

@Composable
fun NecklacesDiagram(seed: Int, modifier: Modifier = Modifier) {
    val textMeasurer = rememberTextMeasurer()

    Canvas(modifier) {
        drawNecklaces(seed, textMeasurer)
    }
}

@Preview(showBackground = true)
@Composable
fun NecklaceDiagramPreview() {
    EmbodyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = RGB(245, 255, 250).toColor()
        ) {
            NecklacesDiagram(6)
        }
    }
}