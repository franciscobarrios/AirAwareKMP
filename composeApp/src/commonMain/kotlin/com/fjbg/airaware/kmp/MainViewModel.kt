package com.fjbg.airaware.kmp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.airaware.kmp.networking.AqiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import util.Result

class MainViewModel(private val client: AqiClient) : ViewModel() {

    private val _getAqi = MutableStateFlow("")
    val getAqi = _getAqi.asStateFlow()

    init {
        println("MainViewModel")
    }

    fun getIAqi() {
        viewModelScope.launch {
            client.getAqi(-39.22, -722.25).collect {
                when (it) {
                    is Result.Error -> {
                        _getAqi.value = "error"
                        println("error")
                        println(it.error.name)
                    }

                    is Result.Success -> {
                        _getAqi.value = "success"
                        println("success")
                        println(it.data.data.aqi)

                    }
                }
            }
        }
    }
}