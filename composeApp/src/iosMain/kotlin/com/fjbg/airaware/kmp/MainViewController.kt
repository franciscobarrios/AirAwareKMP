package com.fjbg.airaware.kmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.fjbg.airaware.kmp.networking.AqiClient
import com.fjbg.airaware.kmp.networking.createHttpClient
import io.ktor.client.engine.darwin.Darwin

fun MainViewController() = ComposeUIViewController {
    App(client = remember { AqiClient(createHttpClient(Darwin.create())) })
}