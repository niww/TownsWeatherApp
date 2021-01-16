package com.github.niww.townsweatherapp.ui

import android.util.Log
import com.github.niww.townsweatherapp.data.api.keyapi.ApiHolder
import com.github.niww.townsweatherapp.model.WeatherOfCity

object LoadData {
    var weather: WeatherOfCity? = null

    fun loadWeather(): WeatherOfCity? {
        Thread(Runnable {
            weather = ApiHolder.api.getWeather().execute().body()

            Log.d("loadWeather", "${ApiHolder.api.getWeather().execute().isSuccessful}")

            Log.d("loadWeather", "${ApiHolder.api.getWeather().execute().body().toString()}")

            Log.d("loadWeather", "${ApiHolder.api.getDailyWeather().execute().body().toString()}")
        }).start()

        return  weather
    }

}