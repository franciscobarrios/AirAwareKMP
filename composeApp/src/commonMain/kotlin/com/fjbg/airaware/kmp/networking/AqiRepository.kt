package com.fjbg.airaware.kmp.networking

import com.fjbg.airaware.kmp.model.AqiDto
import com.fjbg.airaware.kmp.util.AQI_KEY
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import util.NetworkError
import util.Result

class AqiRepository(private val httpClient: HttpClient) {

    suspend fun getAqi(lat: Double, lon: Double): Flow<Result<AqiDto, NetworkError>> {
        val str =
            "https://api.waqi.info/feed/geo:${lat};${lon}/?token=$AQI_KEY"
        val response = httpClient.get(urlString = str)
        return flowOf(
            when (response.status.value) {
                in 200..299 -> {
                    val result = response.body<AqiDto>()
                    Result.Success(result)
                }

                401 -> Result.Error(NetworkError.UNAUTHORIZED)
                408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
                409 -> Result.Error(NetworkError.CONFLICT)
                in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
                else -> Result.Error(NetworkError.UNKNOWN)
            }
        )
    }
}