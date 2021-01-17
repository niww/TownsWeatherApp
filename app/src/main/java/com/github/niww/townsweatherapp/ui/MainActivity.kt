package com.github.niww.townsweatherapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.niww.townsweatherapp.R
import com.github.niww.townsweatherapp.model.WeatherOfCity

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        var data: WeatherOfCity? = null
        val rv = findViewById<RecyclerView>(R.id.rv)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        var adapterRV = Adapter(data)

        rv.apply {
            layoutManager = linearLayoutManager
            adapter = adapterRV
        }

        mainViewModel.liveDataDay().observe(this, {
            data = it
            rv.adapter = Adapter(data)
            adapterRV.notifyDataSetChanged()

        })
        mainViewModel.liveDataDaily().observe(this, {
            var daily = data?.copy( dailyList = it)


            rv.adapter = Adapter(daily)
            adapterRV.notifyDataSetChanged()
            Log.d("loadWeather getLiveData", "${it}")

        })




    }

}