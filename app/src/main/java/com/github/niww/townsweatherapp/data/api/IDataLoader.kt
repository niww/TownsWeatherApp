package com.github.niww.townsweatherapp.data.api

import com.github.niww.townsweatherapp.data.api.keyapi.KEY_API
import com.github.niww.townsweatherapp.model.DailyList
import com.github.niww.townsweatherapp.model.WeatherOfCity
import retrofit2.Call
import retrofit2.http.GET

interface IDataLoader {


    @GET("/data/2.5/weather?q=Moscow&appid=$KEY_API")
    fun getWeather():Call<WeatherOfCity>
    @GET("/data/2.5/onecall?lat=33.441792&lon=-94.037689&exclude=hourly&appid=$KEY_API")
    fun getDailyWeather():Call<DailyList>


}