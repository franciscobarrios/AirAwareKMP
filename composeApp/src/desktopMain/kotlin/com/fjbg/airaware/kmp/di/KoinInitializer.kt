package com.fjbg.airaware.kmp.di

import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(appModules, viewModelModule)
        }
    }
}