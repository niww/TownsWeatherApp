package com.github.niww.townsweatherapp.ui

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    fun liveDataDay() = LoadData.getLiveDataDay()
    fun liveDataDaily() = LoadData.getLiveDataDaily()
}