package com.example.embody

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.embody.graphics.Point
import com.example.embody.graphics.drawAxes
import com.example.embody.graphics.drawNecklace
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
//        val neck = getNecklaces(6)
        drawAxes()
        drawNecklace(
            Point(center.x, size.height / 4),
            3 * size.width / 8f,
            listOf(
                true, false, true, false,
                true, true, false, true,
                false
            ),
            30
        )
        drawNecklace(
            Point(center.x, 3 * size.height / 4),
            3 * size.width / 8f,
            listOf(
                true, false, true, false,
                true, true, false, true,
                false, true, false, true,
                false, true, false, true,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EmbodyTheme {
        CirclesAndStuff()
    }
}