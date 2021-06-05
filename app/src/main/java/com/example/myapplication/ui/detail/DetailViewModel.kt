package com.example.myapplication.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.source.AppRepository
import com.example.myapplication.data.source.local.entity.MovieEntity
import com.example.myapplication.vo.Resource

class DetailViewModel(private val appRepository: AppRepository) : ViewModel() {
    val movieId = MutableLiveData<Int>()

    fun setSelectedMovie(movieId: Int) {
        this.movieId.value = movieId
    }

    var getMovieDetail: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        appRepository.getMovieDetail(mMovieId)
    }

    fun setAsFavMovie(){
        val resource = getMovieDetail.value
        if (resource != null) {
            if (resource.data != null){
                val newState = !resource.data.isFavorite
                appRepository.setFavoriteMovie(resource.data,newState)
            }
        }
    }

}