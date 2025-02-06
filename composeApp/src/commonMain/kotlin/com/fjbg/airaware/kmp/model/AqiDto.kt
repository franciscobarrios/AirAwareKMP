package com.fjbg.airaware.kmp.model

import kotlinx.serialization.Serializable

@Serializable
data class AqiDto(
    val status: String,
    val data: Data,
)

@Serializable
data class Data(
    val idx: Long,
    val aqi: Long,
    val time: Time,
    val city: City,
    val iaqi: Iaqi,
    val forecast: Forecast,
)

@Serializable
data class Time(
    val v: Long,
    val s: String,
    val tz: String,
)

@Serializable
data class City(
    val name: String,
    val url: String,
    val geo: List<Double>,
)

@Serializable
data class Iaqi(
    val pm25: Pm25,
)

@Serializable
data class Pm25(
    val v: Long,
)

@Serializable
data class Forecast(
    val daily: Daily,
)

@Serializable
data class Daily(
    val pm25: List<Pm252>,
)

@Serializable
data class Pm252(
    val avg: Long,
    val day: String,
    val max: Long,
    val min: Long,
)
