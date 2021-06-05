package com.example.myapplication.ui.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.myapplication.data.source.AppRepository
import com.example.myapplication.data.source.local.entity.TvShowEntity
import com.example.myapplication.vo.Resource

class SeriesViewModel(private val appRepository: AppRepository): ViewModel() {
    fun getSeries(): LiveData<Resource<PagedList<TvShowEntity>>> = appRepository.getTvShow(1)

}