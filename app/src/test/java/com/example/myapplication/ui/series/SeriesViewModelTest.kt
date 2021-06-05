package com.example.myapplication.ui.series

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.myapplication.data.source.AppRepository
import com.example.myapplication.data.source.local.entity.TvShowEntity
import com.example.myapplication.vo.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SeriesViewModelTest {

    private lateinit var viewModel: SeriesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>

    @Before
    fun setUp() {
        viewModel = SeriesViewModel(appRepository)
    }

    @Test
    fun getSeries(){
        val dummyTvShows = Resource.success(pagedList)
        `when`(dummyTvShows.data?.size).thenReturn(10)
        val tvShows = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShows.value = dummyTvShows


        `when`(appRepository.getTvShow(1)).thenReturn(tvShows)
        val listTvShow = viewModel.getSeries().value?.data
        verify(appRepository).getTvShow(1)
        assertNotNull(listTvShow)
        assertEquals(10, listTvShow?.size)

        viewModel.getSeries().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }

}