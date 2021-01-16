package com.github.niww.townsweatherapp.data.api.keyapi

import com.github.niww.townsweatherapp.data.api.IDataLoader
import com.github.niww.townsweatherapp.model.WeatherOfCity
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiHolder {

    val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    val api :IDataLoader by lazy {
        val retrofit =Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        retrofit.create(IDataLoader::class.java)
    }

}