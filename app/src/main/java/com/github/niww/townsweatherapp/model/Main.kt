package com.github.niww.townsweatherapp.model

import kotlin.math.absoluteValue
import kotlin.math.roundToInt

data class Main(
    val temp: Double,
    val pressure:String,
    val feelsLike: String
)