package com.example.myapplication.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var name: String,
    @SerializedName("overview")
    var desc: String,
    @SerializedName("poster_path")
    var poster: String
)
