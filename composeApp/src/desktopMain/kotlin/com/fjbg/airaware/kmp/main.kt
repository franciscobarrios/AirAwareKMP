package com.fjbg.airaware.kmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.fjbg.airaware.kmp.networking.AqiClient

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "AirAwareKMP",
    ) {
        App(client = remember { AqiClient(/*createHttpClient(OkHttp.create())*/) })
    }
}