package com.example.myapplication.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.myapplication.data.source.local.LocalDataSource
import com.example.myapplication.data.source.local.entity.MovieEntity
import com.example.myapplication.data.source.local.entity.TvShowEntity
import com.example.myapplication.data.source.remote.RemoteDataSource
import com.example.myapplication.utils.AppExecutors
import com.example.myapplication.utils.DataDummy
import com.example.myapplication.utils.LiveDataTestUtil
import com.example.myapplication.utils.PagedListUtil
import com.example.myapplication.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.Mockito.*

class AppRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val appRepository = FakeAppRepository(remote,local,appExecutors)


    private val listMovieResponse = DataDummy.generateDataMovieDummy()
    private val listTvShowResponse = DataDummy.generateDataTvShowDummy()
    private val listMovieFavoriteResponse = DataDummy.generateDummyMovieFavorite()
    private val listTvShowFavoriteResponse = DataDummy.generateDummyTvShowFavorite()
    private val movieId = listMovieResponse[0].movieId
    private val tvShowId = listTvShowResponse[0].tvShowId
    private val movieResponse = DataDummy.generateDataMovieDummy()[0]
    private val tvShowResponse = DataDummy.generateDataTvShowDummy()[0]

    @Test
    fun getMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        appRepository.getMovies(1)
        val movies = Resource.success(PagedListUtil.mockPagedList(listMovieResponse))
        verify(local).getMovies()
        assertNotNull(movies.data)
        assertEquals(listMovieResponse.size.toLong(), movies.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = movieResponse

        `when`(local.getMovieDetail(movieId)).thenReturn(movie)
        val resultMovie = LiveDataTestUtil.getValue(appRepository.getMovieDetail(movieId))
        verify(local).getMovieDetail(movieId)
        assertNotNull(resultMovie.data)
        assertEquals(movieResponse.movieId, resultMovie.data?.movieId)
        assertEquals(movieResponse.name, resultMovie.data?.name)
        assertEquals(movieResponse.desc, resultMovie.data?.desc)
        assertEquals(movieResponse.poster, resultMovie.data?.poster)
        assertEquals(movieResponse.isFavorite, resultMovie.data?.isFavorite)
    }

    @Test
    fun getTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShow()).thenReturn(dataSourceFactory)
        appRepository.getTvShow(1)
        val tvShows = Resource.success(PagedListUtil.mockPagedList(listTvShowResponse))
        verify(local).getTvShow()
        assertNotNull(tvShows.data)
        assertEquals(listTvShowResponse.size.toLong(), tvShows.data?.size?.toLong())
    }

    @Test
    fun getTvShowDetail() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = tvShowResponse

        `when`(local.getTvShowDetail(tvShowId)).thenReturn(tvShow)
        val resultTvShow = LiveDataTestUtil.getValue(appRepository.getTvShowDetail(tvShowId))
        verify(local).getTvShowDetail(tvShowId)
        assertNotNull(resultTvShow.data)
        assertEquals(tvShowResponse.tvShowId, resultTvShow.data?.tvShowId)
        assertEquals(tvShowResponse.name, resultTvShow.data?.name)
        assertEquals(tvShowResponse.desc, resultTvShow.data?.desc)
        assertEquals(tvShowResponse.poster, resultTvShow.data?.poster)
        assertEquals(tvShowResponse.isFavorite, resultTvShow.data?.isFavorite)
    }

    @Test
    fun getFavMovie(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavMovie()).thenReturn(dataSourceFactory)
        appRepository.getFavMovie()
        val movies = Resource.success(PagedListUtil.mockPagedList(listMovieFavoriteResponse))
        verify(local).getFavMovie()
        assertNotNull(movies)
        assertEquals(listMovieFavoriteResponse.size.toLong(), movies.data?.size?.toLong())
    }

    @Test
    fun getFavTvShow(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavTvShow()).thenReturn(dataSourceFactory)
        appRepository.getFavTvShow()
        val tvShows = Resource.success(PagedListUtil.mockPagedList(listTvShowFavoriteResponse))
        verify(local).getFavTvShow()
        assertNotNull(tvShows)
        assertEquals(listTvShowFavoriteResponse.size.toLong(), tvShows.data?.size?.toLong())
    }

    @Test
    fun setFavoriteMovie(){
        val movie = DataDummy.generateDataMovieDummy()[0]
        appRepository.setFavoriteMovie(movie, true)
        verify(local).setFavoriteMovie(movie, true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun setFavoriteTvShow(){
        val tvShow = DataDummy.generateDataTvShowDummy()[0]
        appRepository.setFavoriteTvShow(tvShow, true)
        verify(local).setFavoriteTvShow(tvShow, true)
        verifyNoMoreInteractions(local)
    }


}