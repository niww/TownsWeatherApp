package com.github.niww.townsweatherapp.data.api

import androidx.lifecycle.LiveData
import com.github.niww.townsweatherapp.data.api.keyapi.KEY_API
import com.github.niww.townsweatherapp.model.DailyList
import com.github.niww.townsweatherapp.model.WeatherOfCity
import retrofit2.Call
import retrofit2.http.GET

interface IDataLoader {


    @GET("/data/2.5/weather?q=Moscow&units=metric&appid=$KEY_API")
    fun getWeather(): Call<WeatherOfCity>

    //[55.7522, 37.6156]
    @GET("/data/2.5/onecall?lat=55.7522&lon=37.6156&units=metric&exclude=hourly&appid=$KEY_API")
    fun getDailyWeather(): Call<DailyList>


}