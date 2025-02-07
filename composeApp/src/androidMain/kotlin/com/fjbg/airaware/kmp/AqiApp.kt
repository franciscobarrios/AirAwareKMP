package com.fjbg.airaware.kmp

import android.app.Application
import com.fjbg.airaware.kmp.di.initKoin
import org.koin.android.ext.koin.androidContext

class AqiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@AqiApp)
        }
    }
}