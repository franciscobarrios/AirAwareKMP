package com.fjbg.airaware.kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter,

        ) {
        AqiCircle()
        Text(
            "123",
            fontSize = 72.sp,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.Center), maxLines = 1
        )
    }
}

@Composable
fun AqiCircle() {
    Canvas(
        modifier = Modifier.fillMaxSize(),
        onDraw = {
            drawCircle(
                color = Color.Gray,
                radius = 360f,
                style = Stroke(width = 24f)
            )

        })
}