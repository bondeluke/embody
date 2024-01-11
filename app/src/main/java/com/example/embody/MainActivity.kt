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
import com.example.embody.math.necklace.Necklace
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
//        val all = necklaces.values.flatten()
        val numRows = necklaces.size
        val padding = (size.height / numRows) / 5
        for (row in 0..<necklaces.size) {
            val rowNecklaces = necklaces[row]
            val numColumns = rowNecklaces!!.size
            for (col in rowNecklaces.indices) {
                val x = getRatioBasedOnIndex(col, numColumns)
                val y = getRatioBasedOnIndex(row, numRows)
                drawNecklace(
                    center = Point(x * size.width, y * size.height),
                    radius = size.height / (numRows * 2) - padding,
                    values = getElements(rowNecklaces[col])
                )
            }
        }
    }
}

fun getElements(necklace: Necklace): List<Boolean> {
    val elements = mutableListOf<Boolean>()

    for (i in 0..<necklace.order)
        elements.add(false)

    var counter = 0
    for (element in necklace.elements) {
        counter = counter + necklace.order - element
        counter %= necklace.order
        elements[counter] = true
    }

    return elements
}

fun getRatioBasedOnIndex(index: Int, total: Int): Float {
    return (index.toFloat() / total + 1f / (total * 2f))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EmbodyTheme {
        CirclesAndStuff()
    }
}