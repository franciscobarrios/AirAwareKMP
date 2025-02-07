package com.fjbg.airaware.kmp.di

import com.fjbg.airaware.kmp.MainViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val viewModelModule = module {
    singleOf(::MainViewModel)
}