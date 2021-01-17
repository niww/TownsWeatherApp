package com.github.niww.townsweatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.niww.townsweatherapp.R
import com.github.niww.townsweatherapp.model.WeatherOfCity
import com.github.niww.townsweatherapp.ui.image.ImageLoaderGlide

class Adapter(weatherOfCity: WeatherOfCity?) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    val listOfWeather = weatherOfCity


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listOfWeather)

        if (listOfWeather?.dailyList?.daily != null) {

            val dailyWeatherAdapter = DailyWeatherAdapter(listOfWeather!!.dailyList.daily)
            val linearLayoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)

            holder.dailyRV.apply {
                adapter = dailyWeatherAdapter
                layoutManager = linearLayoutManager
                dailyWeatherAdapter.notifyDataSetChanged()
            }

        }

    }

    override fun getItemCount() = 1

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cityName = itemView.findViewById<TextView>(R.id.city_name)
        val weather = itemView.findViewById<TextView>(R.id.weather_of_city)
        val dailyRV = itemView.findViewById<RecyclerView>(R.id.rv_daily_weather)

        fun onBind(weatherOfCity: WeatherOfCity?) {
            cityName.text = weatherOfCity?.name
            weather.text = weatherOfCity?.main?.temp.toString()
        }
    }
}
