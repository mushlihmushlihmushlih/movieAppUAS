package com.example.myapplication.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.myapplication.data.source.AppRepository
import com.example.myapplication.data.source.local.entity.TvShowEntity
import com.example.myapplication.utils.DataDummy
import com.example.myapplication.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = Resource.success(DataDummy.generateDataTvShowDummy()[0])
    private val tvShowId = dummyTvShow.data?.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(appRepository)
        if (tvShowId != null) {
            viewModel.setSelectedTvShow(tvShowId)
        }
    }

    @Test
    fun getTvShowDetail() {
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyTvShow
        `when`(appRepository.getTvShowDetail(tvShowId!!)).thenReturn(tvShow)
        viewModel.getTvShowDetail.observeForever(tvShowObserver)
        Mockito.verify(tvShowObserver).onChanged(dummyTvShow)
    }

    @Test
    fun setAsFavTvShow() {
        val dummyTvShow = Resource.success(DataDummy.generateDataTvShowDummy()[0])
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyTvShow
        `when`(tvShowId?.let { appRepository.getTvShowDetail(it) }).thenReturn(tvShow)
        viewModel.getTvShowDetail.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(tvShow.value)
        viewModel.setAsFavTvShow()
        verify(appRepository).setFavoriteTvShow(tvShow.value!!.data as TvShowEntity, true)
        verifyNoMoreInteractions(tvShowObserver)
    }

}