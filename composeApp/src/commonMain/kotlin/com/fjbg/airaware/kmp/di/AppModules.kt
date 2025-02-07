package com.fjbg.airaware.kmp.di

import com.fjbg.airaware.kmp.networking.AqiClient
import com.fjbg.airaware.kmp.networking.createHttpClient
import org.koin.dsl.module

val appModules = module {
    single { }
    single { AqiClient(createHttpClient(get())) }
}


