package com.airaware.mobile.networking

import kotlinx.serialization.Serializable

@Serializable
data class AqiWrapperDto(
    val status: String,
    val data: AqiDto?
)

@Serializable
data class AqiDto(
    val idx: Int,
    val aqi: Int,
    val city: CityDto,
    val attributions: List<Attribution>?,
    val iaqi: IAqi?,
    val forecast: Forecast?
)

@Serializable
data class CityDto(
    val name: String,
    val url: String,
    val geo: List<Double>,
    val location: String?,
)

@Serializable
data class Attribution(
    val url: String?,
    val name: String?
)

@Serializable
data class IAqi(
    val co: CarbonMonoxide,
    val h: Humidity,
    val no2: NitrogenDioxide,
    val o3: Ozone,
    val p: Pressure,
    val pm10: PMTen,
    val pm25: PMTwentyFive,
    val so2: SulfurDioxide,
    val t: Temperature,
    val w: Wind,
)

@Serializable
data class CarbonMonoxide(
    val v: Double
)

@Serializable
data class Humidity(
    val v: Double
)

@Serializable
data class NitrogenDioxide(
    val v: Double
)

@Serializable
data class Ozone(
    val v: Double
)

@Serializable
data class Pressure(
    val v: Double
)

@Serializable
data class PMTen(
    val v: Int
)

@Serializable
data class PMTwentyFive(
    val v: Int
)

@Serializable
data class SulfurDioxide(
    val v: Double
)

@Serializable
data class Temperature(
    val v: Int
)

@Serializable
data class Wind(
    val v: Double
)

@Serializable
data class Forecast(
    val daily: ForecastList
)

@Serializable
data class ForecastList(
    val o3: List<ForecastObject>,
    val pm25: List<ForecastObject>,
    val pm10: List<ForecastObject>,
    val uvi: List<ForecastObject>,
)

@Serializable
data class ForecastObject(
    val day: String,
    val avg: Int,
    val min: Int,
    val max: Int,
)