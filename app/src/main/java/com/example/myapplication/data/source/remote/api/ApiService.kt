package com.example.myapplication.data.source.remote.api

import com.example.myapplication.data.source.remote.response.ResponseMovie
import com.example.myapplication.data.source.remote.response.MovieResponse
import com.example.myapplication.data.source.remote.response.ResponseTvShow
import com.example.myapplication.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface   ApiService {
    companion object {

        const val API_KEY = "378aa10ea738ce4cb6ab3dd53569c97d"
    }

    @GET("movie/now_playing?api_key=$API_KEY")
    fun getMovies(
        @Query("page") page: Int
    ) : Call<ResponseMovie>

    @GET("movie/{movie_id}?api_key=$API_KEY")
    fun getMovieDetail(
        @Path("movie_id") movieId: Int?,
    ): Call<MovieResponse>

    @GET("tv/on_the_air?api_key=$API_KEY")
    fun getTvShow(
        @Query("page") page: Int
    ) : Call<ResponseTvShow>

    @GET("tv/{tv_id}?api_key=$API_KEY")
    fun getTvDetail(
        @Path("tv_id") tvShowId: Int?,
    ): Call<TvShowResponse>
}
