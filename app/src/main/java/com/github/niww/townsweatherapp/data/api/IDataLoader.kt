package com.github.niww.townsweatherapp.data.api

import com.github.niww.townsweatherapp.data.api.keyapi.KEY_API
import com.github.niww.townsweatherapp.model.WeatherOfCity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IDataLoader {


    @GET("/data/2.5/weather?q=Moscow&appid=$KEY_API")
    fun getWeather():Call<WeatherOfCity>

}