package com.example.myapplication.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.myapplication.data.source.AppRepository
import com.example.myapplication.data.source.local.entity.TvShowEntity
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SeriesFavoriteViewModelTest {

    private lateinit var viewModel: SeriesFavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = SeriesFavoriteViewModel(appRepository)
    }

    @Test
    fun getFavTvShow() {
        val dummyTvShow = pagedList
        Mockito.`when`(dummyTvShow.size).thenReturn(10)
        val favTvShow = MutableLiveData<PagedList<TvShowEntity>>()
        favTvShow.value = dummyTvShow


        Mockito.`when`(appRepository.getFavTvShow()).thenReturn(favTvShow)
        val listTvShow = viewModel.getFavoriteTvShow().value
        Mockito.verify(appRepository).getFavTvShow()
        Assert.assertNotNull(listTvShow)
        Assert.assertEquals(10, listTvShow?.size)

        viewModel.getFavoriteTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShow)
    }
}
