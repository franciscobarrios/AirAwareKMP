package com.fjbg.airaware.kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.fjbg.airaware.kmp.di.initKoin

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "AirAwareKMP",
    ) {
        App()
    }
}