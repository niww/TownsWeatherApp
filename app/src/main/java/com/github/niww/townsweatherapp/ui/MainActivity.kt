package com.github.niww.townsweatherapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
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

        val data = LoadData.loadWeather()

        rv.apply {
            layoutManager = linearLayoutManager
            adapter = Adapter(data)
        }


    }
}