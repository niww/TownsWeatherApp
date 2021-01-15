package com.github.niww.townsweatherapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.niww.townsweatherapp.R
import com.github.niww.townsweatherapp.model.WeatherOfCity

class Adapter() : RecyclerView.Adapter<Adapter.ViewHolder>() {

    val listOfWeather = mutableListOf("1","1")

    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cityName = itemView.findViewById<TextView>(R.id.city_name)
        val weather = itemView.findViewById<TextView>(R.id.weather_of_city)

        fun onBind(city: String?, weatherOfCity: String?) {
            cityName.text = city
            weather.text = weatherOfCity.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        holder.onBind(listOfWeather[position].cod, listOfWeather[position].message)
//        holder.onBind(listOfWeather[position].name, listOfWeather[position].feelsLike)
    }

    override fun getItemCount() = listOfWeather.size
}