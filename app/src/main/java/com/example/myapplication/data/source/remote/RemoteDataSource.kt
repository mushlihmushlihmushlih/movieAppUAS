package com.example.myapplication.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.source.remote.api.ApiConfig
import com.example.myapplication.data.source.remote.api.ApiResponse
import com.example.myapplication.data.source.remote.response.MovieResponse
import com.example.myapplication.data.source.remote.response.ResponseMovie
import com.example.myapplication.data.source.remote.response.ResponseTvShow
import com.example.myapplication.data.source.remote.response.TvShowResponse
import com.example.myapplication.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource{

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null
        private var TAG = RemoteDataSource::class.java.simpleName

        fun getInstance(): RemoteDataSource {
            return RemoteDataSource()
        }
    }

    fun getMovies(page: Int): LiveData<ApiResponse<List<MovieResponse>>> {
        val resultMovies = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        val client = ApiConfig.getApiService().getMovies(page)
        EspressoIdlingResource.increment()

        client.enqueue(object : Callback<ResponseMovie> {
            override fun onResponse(call: Call<ResponseMovie>, response: Response<ResponseMovie>) {
                if (response.isSuccessful) {
                    resultMovies.value = ApiResponse.success(response.body()!!.results)
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return resultMovies
    }

    fun getTvShow(page: Int): LiveData<ApiResponse<List<TvShowResponse>>> {
        val resultTvShows = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        val client = ApiConfig.getApiService().getTvShow(page)
        EspressoIdlingResource.increment()

        client.enqueue(object : Callback<ResponseTvShow> {
            override fun onResponse(call: Call<ResponseTvShow>, response: Response<ResponseTvShow>) {
                if (response.isSuccessful) {
                    resultTvShows.value = ApiResponse.success(response.body()!!.results)
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseTvShow>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return resultTvShows
    }

    fun getMovieDetail(id: Int): LiveData<ApiResponse<MovieResponse>> {

        val movie = MutableLiveData<ApiResponse<MovieResponse>>()
        val client = ApiConfig.getApiService().getMovieDetail(id)
        EspressoIdlingResource.increment()

        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    movie.value = ApiResponse.success(response.body()!!)
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return movie
    }

    fun getTvDetail(id: Int) : LiveData<ApiResponse<TvShowResponse>>{

        val tvShow = MutableLiveData<ApiResponse<TvShowResponse>>()
        val client = ApiConfig.getApiService().getTvDetail(id)
        EspressoIdlingResource.increment()

        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                if (response.isSuccessful) {
                    tvShow.value = ApiResponse.success(response.body()!!)
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return tvShow
    }

}