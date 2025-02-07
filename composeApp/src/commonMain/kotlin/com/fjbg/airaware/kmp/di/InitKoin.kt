package com.fjbg.airaware.kmp.di

import com.fjbg.airaware.kmp.MainViewModel
import com.fjbg.airaware.kmp.networking.AqiClient
import com.fjbg.airaware.kmp.networking.createHttpClient
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration.invoke(this)
    modules(commonModules)
}

val commonModules = module {
    single { createHttpClient(get()) }
    singleOf(::AqiClient)
    viewModelOf(::MainViewModel)
}