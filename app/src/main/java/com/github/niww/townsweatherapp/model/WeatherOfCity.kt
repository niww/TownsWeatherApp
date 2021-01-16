package com.github.niww.townsweatherapp.model

data class WeatherOfCity(
    val id: String,
    val name: String,
    val clouds: Clouds,
    val main: Main
)
