package com.github.niww.townsweatherapp.ui

import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageLoaderGlide {

    fun loadImage(view: ImageView, icon:String){
        val url = "http://openweathermap.org/img/wn/$icon@2x.png"
        Glide
            .with(view.context)
            .load(url)
            .override(200,200)
            .into(view)

    }
}