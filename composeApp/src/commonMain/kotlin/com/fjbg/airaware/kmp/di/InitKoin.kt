package com.fjbg.airaware.kmp.di

import com.fjbg.airaware.kmp.MainViewModel
import com.fjbg.airaware.kmp.networking.AqiRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration.invoke(this)
    modules(
        commonModules,
        provideHttpClient,
        provideRepository,
    )
}

val commonModules = module {
    viewModelOf(::MainViewModel)
}
val provideRepository = module {
    single<AqiRepository> { AqiRepository(get()) }
}
val provideHttpClient = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(HttpTimeout) {
                connectTimeoutMillis = 20 * 1000
            }
        }
    }
}