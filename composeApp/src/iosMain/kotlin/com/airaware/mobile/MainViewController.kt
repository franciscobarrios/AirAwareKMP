package com.airaware.mobile

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.airaware.mobile.networking.AqiHttpClient
import com.airaware.mobile.networking.createHttpClient
import io.ktor.client.engine.darwin.Darwin

fun MainViewController() = ComposeUIViewController {
    App(
        client = remember {
            AqiHttpClient(createHttpClient(Darwin.create()))
        }
    )
}