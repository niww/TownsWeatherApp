package com.github.niww.townsweatherapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.niww.townsweatherapp.R
import com.github.niww.townsweatherapp.data.api.keyapi.ApiHolder
import com.github.niww.townsweatherapp.model.WeatherOfCity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        fun loadWeather(): WeatherOfCity? {
            var weather: WeatherOfCity? = null
            try {

                Thread(Runnable {
                    weather = ApiHolder.api.getWeather().execute().body()
                    Log.d("loadWeather", "${ApiHolder.api.getWeather().execute().body().toString()}")
                    Log.d("loadWeather", "${ApiHolder.api.getWeather().execute().isSuccessful}")
                    //todo convert by gson
                }).start()


            } catch (e: Throwable) {

                Log.d("loadWeather", "$e")
            }
            return  weather
        }

        loadWeather()

        rv.apply {
            layoutManager = linearLayoutManager
            adapter = Adapter()

        }

    }
}