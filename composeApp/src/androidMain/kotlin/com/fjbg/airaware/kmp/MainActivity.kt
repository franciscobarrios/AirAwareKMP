package com.fjbg.airaware.kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.fjbg.airaware.kmp.networking.AqiClient

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(client = remember { AqiClient(/*createHttpClient(OkHttp.create())*/) })
        }
    }
}