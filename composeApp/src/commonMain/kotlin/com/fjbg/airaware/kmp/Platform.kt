package com.fjbg.airaware.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform