package com.example.myapplication.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.myapplication.data.source.AppRepository
import com.example.myapplication.data.source.local.entity.TvShowEntity

class SeriesFavoriteViewModel(private val appRepository: AppRepository): ViewModel() {
    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> = appRepository.getFavTvShow()
}