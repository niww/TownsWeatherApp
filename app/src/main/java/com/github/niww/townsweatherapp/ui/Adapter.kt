package com.github.niww.townsweatherapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.niww.townsweatherapp.R
import com.github.niww.townsweatherapp.model.WeatherOfCity

class Adapter(weatherOfCity:WeatherOfCity?) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    val listOfWeather = mutableListOf(weatherOfCity)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listOfWeather[position]?.name, listOfWeather[position]?.main?.temperature.toString())
    }

    override fun getItemCount() = listOfWeather.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cityName = itemView.findViewById<TextView>(R.id.city_name)
        val weather = itemView.findViewById<TextView>(R.id.weather_of_city)

        fun onBind(city: String?, weatherOfCity: String?) {
            cityName.text = city
            weather.text = weatherOfCity.toString()
        }
    }
}
