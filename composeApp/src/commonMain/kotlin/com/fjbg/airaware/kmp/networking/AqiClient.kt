package com.fjbg.airaware.kmp.networking

import com.fjbg.airaware.kmp.model.AqiDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.host
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import util.NetworkError
import util.Result

class AqiClient(private val httpClient: HttpClient) {

    private val token = "4451728cc993ee1e86af7beeb147657bddd56d46"

    //FIXME: handle invalid key error

    suspend fun getAqi(lat: Double, lon: Double): Result<AqiDto, NetworkError> {
        val response = try {
            //httpClient.get(urlString = "https://api.waqi.info/feed/geo:-39.22;-72.25/")
            val str = "https://api.waqi.info/feed/geo:${lat};${lon}/"
            httpClient.get(urlString = str)
            {
                parameter("token", token)
                contentType(ContentType.Application.Json)
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }
        return when (response.status.value) {
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
    }
}