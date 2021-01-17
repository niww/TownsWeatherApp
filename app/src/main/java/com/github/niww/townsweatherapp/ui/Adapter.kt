package com.github.niww.townsweatherapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.niww.townsweatherapp.R
import com.github.niww.townsweatherapp.model.WeatherOfCity

class Adapter(weatherOfCity: WeatherOfCity?) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    val listOfWeather = mutableListOf(weatherOfCity)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listOfWeather[position]?.name, listOfWeather[position], position)

        if (listOfWeather[0]?.dailyList?.daily?.get(0)?.weather?.get(0)?.icon != null) {
            ImageLoaderGlide().loadImage(
                holder.iconWeather,
                listOfWeather[0]?.dailyList!!.daily[0].weather[0].icon
            )
        }

    }

    override fun getItemCount() = listOfWeather.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cityName = itemView.findViewById<TextView>(R.id.city_name)
        val weather = itemView.findViewById<TextView>(R.id.weather_of_city)
        val tempMax = itemView.findViewById<TextView>(R.id.temp_max)
        val tempMin = itemView.findViewById<TextView>(R.id.temp_min)
        val iconWeather = itemView.findViewById<ImageView>(R.id.iv_of_day)

        fun onBind(city: String?, weatherOfCity: WeatherOfCity?, position: Int) {
            cityName.text = city
            weather.text = weatherOfCity?.main?.temp.toString()
            tempMax.text = weatherOfCity?.dailyList?.daily?.get(0)?.temp?.max.toString()
            tempMin.text = weatherOfCity?.dailyList?.daily?.get(0)?.temp?.min.toString()
        }
    }
}
