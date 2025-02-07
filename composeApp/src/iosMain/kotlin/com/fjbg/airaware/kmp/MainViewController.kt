package com.fjbg.airaware.kmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.fjbg.airaware.kmp.networking.AqiClient

fun MainViewController() = ComposeUIViewController {
    App(client = remember { AqiClient(/*createHttpClient(Darwin.create())*/) })
}