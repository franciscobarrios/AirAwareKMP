package com.airaware.mobile.di

import com.airaware.mobile.MainViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module


expect val platformModule: Module

val sharedModule = module {
    /*single {
        MainViewModel(get())
    }.bind<MainViewModel>()*/

    viewModelOf(::MainViewModel).bind<MainViewModel>()
}


