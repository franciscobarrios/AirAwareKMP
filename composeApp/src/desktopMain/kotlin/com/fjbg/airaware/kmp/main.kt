package com.fjbg.airaware.kmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.jetbrains.compose.ui.tooling.preview.Preview

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "AirAware",
    ) {
        App()
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}