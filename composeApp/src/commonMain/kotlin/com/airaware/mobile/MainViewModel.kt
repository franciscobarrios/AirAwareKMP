package com.airaware.mobile

import androidx.lifecycle.ViewModel
import com.airaware.mobile.networking.AqiHttpClient
import com.airaware.mobile.networking.createHttpClient

class MainViewModel() : ViewModel() {

    suspend fun getAqi() {
    }

    fun getText(): String {
        return "hello world!"
    }
}