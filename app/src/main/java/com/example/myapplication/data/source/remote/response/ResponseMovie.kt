package com.example.myapplication.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseMovie(
    @SerializedName("results")
    val results: MutableList<MovieResponse>
)