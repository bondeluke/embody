package com.example.embody

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.embody.graphics.RGB
import com.example.embody.ui.theme.EmbodyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmbodyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = RGB(245, 255, 250).toColor()
                ) {
                    NecklacesDiagram(6)
                }
            }
        }
    }
}

