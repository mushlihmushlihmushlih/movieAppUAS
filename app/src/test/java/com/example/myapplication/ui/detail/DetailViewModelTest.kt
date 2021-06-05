package com.example.myapplication.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.myapplication.data.DataEntity
import com.example.myapplication.data.source.AppRepository
import com.example.myapplication.data.source.local.entity.MovieEntity
import com.example.myapplication.utils.DataDummy
import com.example.myapplication.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest{
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = Resource.success(DataDummy.generateDataMovieDummy()[0])
    private val movieId = dummyMovie.data?.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(appRepository)
        if (movieId != null) {
            viewModel.setSelectedMovie(movieId)
        }
    }

    @Test
    fun getMovieDetail() {
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie
        `when`(appRepository.getMovieDetail(movieId!!)).thenReturn(movie)
        viewModel.getMovieDetail.observeForever(movieObserver)
        Mockito.verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun setAsFavMovie() {
        val dummyMovie = Resource.success(DataDummy.generateDataMovieDummy()[0])
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie
        `when`(movieId?.let { appRepository.getMovieDetail(it) }).thenReturn(movie)
        viewModel.getMovieDetail.observeForever(movieObserver)
        verify(movieObserver).onChanged(movie.value)
        viewModel.setAsFavMovie()
        verify(appRepository).setFavoriteMovie(movie.value!!.data as MovieEntity, true)
        verifyNoMoreInteractions(movieObserver)
    }

}