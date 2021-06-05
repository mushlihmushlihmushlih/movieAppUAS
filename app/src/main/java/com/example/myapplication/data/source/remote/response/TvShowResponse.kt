package com.example.myapplication.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowResponse(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("overview")
    var desc: String,
    @SerializedName("poster_path")
    var poster: String
)
