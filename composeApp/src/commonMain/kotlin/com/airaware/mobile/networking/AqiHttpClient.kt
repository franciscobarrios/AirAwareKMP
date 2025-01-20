package com.airaware.mobile.networking

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import util.NetworkError
import util.Result

class AqiHttpClient(private val httpClient: HttpClient) {
    suspend fun getAqi(aqiKey: String): Result<AqiWrapperDto, NetworkError> {
        val response = try {
            httpClient.get(
                urlString = "https://api.waqi.info/feed/bangkok/"
            ) {
                parameter("token", aqiKey)
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return when (response.status.value) {
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            in 200..299 -> {
                val result = response.body<AqiWrapperDto>()
                Result.Success(result)
            }

            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }
}