package com.airaware.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.airaware.mobile.networking.AqiHttpClient
import com.airaware.mobile.networking.createHttpClient
import io.ktor.client.engine.okhttp.OkHttp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(
                client = remember {
                    AqiHttpClient(createHttpClient(OkHttp.create()))
                }
            )
        }
    }
}