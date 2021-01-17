package com.github.niww.townsweatherapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.niww.townsweatherapp.data.api.keyapi.ApiHolder
import com.github.niww.townsweatherapp.model.DailyList
import com.github.niww.townsweatherapp.model.WeatherOfCity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LoadData {
    var weather: WeatherOfCity? = null
    var mutableLiveDataDay: MutableLiveData<WeatherOfCity> = MutableLiveData<WeatherOfCity>()
    var mutableLiveDataDailyList: MutableLiveData<DailyList> = MutableLiveData<DailyList>()

    fun getLiveDataDay(): MutableLiveData<WeatherOfCity> {

        val call = ApiHolder.api.getWeather()
        call.enqueue(object : Callback<WeatherOfCity> {
            override fun onResponse(call: Call<WeatherOfCity>, response: Response<WeatherOfCity>) {
                mutableLiveDataDay.value = response.body()
                Log.d("loadWeather getLiveData", "${mutableLiveDataDay.toString()}")
            }

            override fun onFailure(call: Call<WeatherOfCity>, t: Throwable) {
                Log.d("loadWeather getLiveData", "$t")

            }
        })

        return mutableLiveDataDay
    }

    fun getLiveDataDaily(): MutableLiveData<DailyList> {

        val call = ApiHolder.api.getDailyWeather()
        call.enqueue(object : Callback<DailyList> {
            override fun onResponse(call: Call<DailyList>, response: Response<DailyList>) {
                mutableLiveDataDailyList.value = response.body()
                Log.d("loadWeather getLiveData", "${mutableLiveDataDailyList.toString()}")
            }

            override fun onFailure(call: Call<DailyList>, t: Throwable) {
                Log.d("loadWeather getLiveData", "$t")
            }

        })

        return mutableLiveDataDailyList
    }

}