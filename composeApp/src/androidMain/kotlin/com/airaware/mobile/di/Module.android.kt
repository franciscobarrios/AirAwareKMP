package com.airaware.mobile.di

import com.airaware.mobile.MainViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule = module {
    viewModelOf(::MainViewModel).bind<MainViewModel>()
}