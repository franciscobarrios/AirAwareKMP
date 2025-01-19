package com.airaware.mobile.model

data class AqiWrapper(
    val status: String,
    val data: Aqi,
)

data class Aqi(
    val idx: Int,
    val aqi: Int,
    val time: AqiTime,
    val city: AqiCity,

    )

data class AqiTime(
    val value: Int,
    val time: String,
    val timezone: String,
)

data class AqiCity(
    val name: String,
    val url: String,
    val geo: List<CityGeo>,
)

data class CityGeo(
    val lat: Double, val lng: Double
)

data class Pm25(
    val value: Int,
)

//"data": {
//        idx:7397,
//        aqi:71,
//        time:{
//            v:1481396400,
//            s:"2016-12-10 19:00:00",
//            tz:"-06:00"
//        },
//        city:{
//            name:"Chi_sp, Illinois",
//            url:"https://aqicn.org/city/usa/illinois/chi_sp/",
//            geo:["41.913600","-87.723900"]
//        },
//        iaqi:{
//            pm25:{
//                v:71
//            }
//        },
//        forecast:{
//            daily: {
//                pm25: [{
//                    avg: 154,
//                    day: "2020-06-13",
//                    max: 157,
//                    min: 131
//                }, {
//                    avg: 163,
//                    day: "2020-06-14",
//                    max: 173,
//                    min: 137
//                }]
//            }
//        }