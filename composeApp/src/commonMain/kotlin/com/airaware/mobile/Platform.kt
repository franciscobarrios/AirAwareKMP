package com.airaware.mobile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform