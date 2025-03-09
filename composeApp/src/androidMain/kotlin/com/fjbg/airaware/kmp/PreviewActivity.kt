package com.fjbg.airaware.kmp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class PreviewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}


@Preview(showBackground = true, showSystemUi = true,
    device = "id:pixel_9",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun AppPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .weight(.2f, true)

        ) {
            CityInfoPreview()
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .weight(.6f, true)
        ) {
            AqiTextPreview()
            AqiCirclePreview()
        }

        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .weight(.2f, true)
        ) {

            HistoryPreview()
        }
    }
}

@Composable
fun CityInfoPreview() {
    Text(
        "Bangkok, Thailand",
        fontSize = 32.sp,
        color = Color.Gray,
        modifier = Modifier.padding(16.dp),
        maxLines = 1
    )
}

@Composable
fun AqiTextPreview() {
    Text(
        "98",
        fontSize = 102.sp,
        color = Color.DarkGray,
        modifier = Modifier.padding(16.dp),
        maxLines = 1
    )
}


@Composable
fun AqiCirclePreview() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), onDraw = {
            drawCircle(
                color = Color.Gray, radius = 340f, style = Stroke(width = 24f), center = size.center
            )
        })
}

@Composable
fun HistoryPreview() {
    Canvas(
        modifier = Modifier.padding(16.dp), onDraw = {
            drawRoundRect(
                color = Color.Red, cornerRadius = CornerRadius(10f, 10f), size = Size(32f, 240f)
            )
        })

    Text("M")
}