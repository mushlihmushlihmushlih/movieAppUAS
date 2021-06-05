package com.example.myapplication.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.myapplication.data.source.AppRepository
import com.example.myapplication.data.source.local.entity.MovieEntity
import com.example.myapplication.ui.movie.MovieViewModel
import com.example.myapplication.vo.Resource
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieFavoriteViewModelTest {

    private lateinit var viewModel: MovieFavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = MovieFavoriteViewModel(appRepository)
    }

    @Test
    fun getFavMovies() {
        val dummyMovies = pagedList
        Mockito.`when`(dummyMovies.size).thenReturn(10)
        val favMovies = MutableLiveData<PagedList<MovieEntity>>()
        favMovies.value = dummyMovies


        Mockito.`when`(appRepository.getFavMovie()).thenReturn(favMovies)
        val listMovie = viewModel.getFavoriteMovie().value
        Mockito.verify(appRepository).getFavMovie()
        Assert.assertNotNull(listMovie)
        Assert.assertEquals(10, listMovie?.size)

        viewModel.getFavoriteMovie().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }
}
