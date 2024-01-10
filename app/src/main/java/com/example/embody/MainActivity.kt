package com.example.embody

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.embody.graphics.Point
import com.example.embody.graphics.drawAxes
import com.example.embody.graphics.drawNecklace
import com.example.embody.math.necklace.getNecklaces
import com.example.embody.ui.theme.EmbodyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmbodyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CirclesAndStuff()
                }
            }
        }
    }
}

@Composable
fun CirclesAndStuff(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        drawAxes()

        val necklaces = getNecklaces(6).map { it.key }.groupBy { it.elements.size }
        val numLevels = necklaces.size
        val increments = 2 * numLevels
        val padding = (size.height / numLevels) / 5
        for (increment in (1..<increments step 2)) {
            drawNecklace(
                center = Point(center.x, increment * size.height / increments),
                radius = size.height / (numLevels * 2) - padding,
                values = listOf(true, false, true, false, true, true)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EmbodyTheme {
        CirclesAndStuff()
    }
}