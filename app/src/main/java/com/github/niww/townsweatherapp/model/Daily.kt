package com.github.niww.townsweatherapp.model

data class Daily(
    val dt:String,
    val sunrise:String,
    val sunset:String,
    val pressure:String,
    val temp: DailyTemp,
    val weather: List<WeatherInDaily>
){

}
