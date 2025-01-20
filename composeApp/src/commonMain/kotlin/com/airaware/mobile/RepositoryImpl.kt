package com.airaware.mobile

import com.airaware.mobile.networking.AqiHttpClient
import com.airaware.mobile.networking.AqiWrapperDto
import com.airaware.mobile.util.AQI_KEY
import util.NetworkError
import util.Result

class RepositoryImpl : Repository {
    override suspend fun getAqi(httpClient: AqiHttpClient): Result<AqiWrapperDto, NetworkError> {
        return when (val result = httpClient.getAqi(AQI_KEY)) {
            is Result.Error -> Result.Error(NetworkError.SERVER_ERROR)
            is Result.Success -> {
                Result.Success(result.data)
            }
        }
    }
}

interface Repository {
    suspend fun getAqi(httpClient: AqiHttpClient): Result<AqiWrapperDto, NetworkError>
}