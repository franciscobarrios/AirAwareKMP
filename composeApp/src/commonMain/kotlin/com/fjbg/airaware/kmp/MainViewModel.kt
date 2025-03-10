package com.fjbg.airaware.kmp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.airaware.kmp.model.AqiDto
import com.fjbg.airaware.kmp.networking.AqiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import util.Result

class MainViewModel(private val aqiRepository: AqiRepository) : ViewModel() {

    private val _getAqi = MutableStateFlow<UiState>(UiState.Loading)
    val getAqi = _getAqi.asStateFlow()

    init {
        getAqi()
    }

    private fun getAqi() {
        viewModelScope.launch {
            _getAqi.value = UiState.Loading
            aqiRepository.getAqi(-39.22, -722.25).collect {
                when (it) {
                    is Result.Error -> {
                        _getAqi.value = UiState.Error(it.error.name)
                    }

                    is Result.Success -> {
                        _getAqi.value = UiState.Success(it.data)
                    }
                }
            }
        }
    }

    sealed class UiState {
        data object Loading : UiState()
        data class Success(val data: AqiDto) : UiState()
        data class Error(val message: String) : UiState()
    }
}