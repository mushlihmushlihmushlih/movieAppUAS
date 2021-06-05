package com.example.myapplication.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.myapplication.data.source.AppRepository
import com.example.myapplication.data.source.local.entity.MovieEntity
import com.example.myapplication.vo.Resource

class MovieViewModel(private val appRepository: AppRepository): ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = appRepository.getMovies(1)

}