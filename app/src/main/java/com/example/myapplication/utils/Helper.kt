package com.example.myapplication.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object Helper {

    const val API_IMAGE_ENDPOINT = "https://image.tmdb.org/t/p/"
    const val ENDPOINT_POSTER_SIZE_W185 = "w185"


    fun setImageWithGlide(context: Context, imagePath: String, imageView: ImageView) {
        Glide.with(context)
            .clear(imageView)
        Glide.with(context)
            .load(imagePath)
            .into(imageView)
    }
}