package com.airaware.mobile

import androidx.compose.ui.window.ComposeUIViewController
import com.airaware.mobile.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) {
    App()
}