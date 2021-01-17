package com.github.niww.townsweatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.niww.townsweatherapp.R
import com.github.niww.townsweatherapp.model.Daily
import com.github.niww.townsweatherapp.model.WeatherOfCity
import com.github.niww.townsweatherapp.ui.image.ImageLoaderGlide

class DailyWeatherAdapter(val dailyList:List<Daily>) : RecyclerView.Adapter<DailyWeatherAdapter.VH>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        LayoutInflater.from(parent.context).inflate(
            R.layout.daily_weather_recycler_view, parent, false
        )
    )

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.onBind(dailyList,position)
            ImageLoaderGlide().loadImage(
                holder.iconWeather,
                dailyList[position].weather[0].icon
            )
        }


    override fun getItemCount() = dailyList.size


    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tempMax = itemView.findViewById<TextView>(R.id.temp_max)
        val tempMin = itemView.findViewById<TextView>(R.id.temp_min)
        val iconWeather = itemView.findViewById<ImageView>(R.id.icon_of_day)


        fun onBind(daily: List<Daily>, position: Int) {
            tempMax.text = daily[position].temp.max.toString()
            tempMin.text = daily[position].temp.min.toString()

        }
    }
}
