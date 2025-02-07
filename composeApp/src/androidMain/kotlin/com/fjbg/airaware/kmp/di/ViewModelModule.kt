package com.fjbg.airaware.kmp.di

import com.fjbg.airaware.kmp.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

actual val viewModelModule = module {
    viewModelOf(::MainViewModel)
}