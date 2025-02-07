package com.fjbg.airaware.kmp

import android.app.Application
import com.fjbg.airaware.kmp.di.KoinInitializer

class AqiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}