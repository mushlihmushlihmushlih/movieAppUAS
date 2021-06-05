package com.example.myapplication.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.source.AppRepository
import com.example.myapplication.di.Injection
import com.example.myapplication.ui.detail.DetailTvShowViewModel
import com.example.myapplication.ui.detail.DetailViewModel
import com.example.myapplication.ui.favorite.MovieFavoriteViewModel
import com.example.myapplication.ui.favorite.SeriesFavoriteViewModel
import com.example.myapplication.ui.movie.MovieViewModel
import com.example.myapplication.ui.series.SeriesViewModel

class ViewModelFactory private constructor(private val mAppRespository: AppRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideAppRepository(context)).apply {
                    instance = this
                }
            }
    }


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mAppRespository) as T
            }
            modelClass.isAssignableFrom(SeriesViewModel::class.java) -> {
                SeriesViewModel(mAppRespository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mAppRespository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                DetailTvShowViewModel(mAppRespository) as T
            }
            modelClass.isAssignableFrom(MovieFavoriteViewModel::class.java) -> {
                MovieFavoriteViewModel(mAppRespository) as T
            }
            modelClass.isAssignableFrom(SeriesFavoriteViewModel::class.java) -> {
                SeriesFavoriteViewModel(mAppRespository) as T
            }

            else -> throw Throwable("Unkown ViewModel class")
        }
    }
}