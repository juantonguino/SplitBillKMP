package com.kmp.splitbillkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform