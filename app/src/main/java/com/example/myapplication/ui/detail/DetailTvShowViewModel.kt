package com.example.myapplication.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.source.AppRepository
import com.example.myapplication.data.source.local.entity.TvShowEntity
import com.example.myapplication.vo.Resource

class DetailTvShowViewModel (private val appRepository: AppRepository) : ViewModel(){
    val tvShowId = MutableLiveData<Int>()

    fun setSelectedTvShow(tvShowId: Int) {
        this.tvShowId.value = tvShowId
    }

    var getTvShowDetail: LiveData<Resource<TvShowEntity>> = Transformations.switchMap(tvShowId) { mTvShowId ->
        appRepository.getTvShowDetail(mTvShowId)
    }

    fun setAsFavTvShow(){
        val resource = getTvShowDetail.value
        if (resource != null) {
            if (resource.data != null){
                val newState = !resource.data.isFavorite
                appRepository.setFavoriteTvShow(resource.data,newState)
            }
        }
    }
}