package com.example.myapplication.data.source.remote.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val BASE_URL = "https://api.themoviedb.org/3/"

    private val httpClient = OkHttpClient.Builder().apply {

    }.build()

    private val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder().apply {
            client(httpClient)
            baseUrl(BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
        }
    }

    val instance: ApiService by lazy {
        retrofit
            .build()
            .create(ApiService::class.java)
    }
}