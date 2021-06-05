package com.example.myapplication.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseTvShow(
    @SerializedName("results")
    val results: MutableList<TvShowResponse>
)