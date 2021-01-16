package com.github.niww.townsweatherapp.model

data class Main(
    val temp: Double,
    val pressure:String,
    val feelsLike: String
){
    val temperature :Double
        get() = 273 - temp

}