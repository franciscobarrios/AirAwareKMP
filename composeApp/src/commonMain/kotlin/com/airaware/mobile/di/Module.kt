package com.airaware.mobile.di

import com.airaware.mobile.MainViewModel
import com.airaware.mobile.networking.AqiHttpClient
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module


expect val platformModule: Module

val sharedModule = module {
    viewModelOf(::MainViewModel).bind<MainViewModel>()
    singleOf(::AqiHttpClient).bind<AqiHttpClient>()
}


