package com.fjbg.airaware.kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(
        modifier = Modifier.fillMaxSize(),
        //verticalArrangement = Arrangement.
    ) {

        Row(
            modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .weight(.3f, true)
            //.fillMaxHeight(.2f),
        ) {
            //AqiText()
        }
        Row(
            //contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .weight(.5f, true)
            //.fillMaxHeight(.5f)
        ) {
            //AqiText()
            //AqiCircle()
        }

        Row(
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .weight(.3f, true)
            //.fillMaxHeight(.2f)
        ) {
            //AqiText()
        }
    }
}

@Composable
fun UpperBox() {
    Row(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .fillMaxHeight(.2f),
    ) {
        //AqiText()
    }
}

@Composable
fun MiddleBox() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .fillMaxHeight(.5f)
    ) {
        //AqiText()
        //AqiCircle()
    }
}

@Composable
fun LowerBox() {
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .fillMaxHeight(.2f)
    ) {
        //AqiText()
    }
}

@Composable
fun AqiText() {
    Text(
        "888",
        fontSize = 102.sp,
        color = Color.Gray,
        modifier = Modifier.padding(16.dp),
        maxLines = 1
    )
}


@Composable
fun AqiCircle() {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        onDraw = {
            drawCircle(
                color = Color.Gray,
                radius = 340f,
                style = Stroke(width = 24f),
                center = size.center
            )
        }
    )
}