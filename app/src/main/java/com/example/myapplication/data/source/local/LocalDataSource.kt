package com.example.myapplication.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.myapplication.data.source.local.entity.MovieEntity
import com.example.myapplication.data.source.local.entity.TvShowEntity
import com.example.myapplication.data.source.local.room.AppDao

class LocalDataSource private  constructor(private val appDao: AppDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(appDao: AppDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(appDao)
    }

    fun getMovies(): DataSource.Factory<Int, MovieEntity> = appDao.getMovies()

    fun getFavMovie(): DataSource.Factory<Int, MovieEntity> =
        appDao.getFavMovies()

    fun getTvShow(): DataSource.Factory<Int, TvShowEntity> = appDao.getTvShow()

    fun getFavTvShow(): DataSource.Factory<Int, TvShowEntity> =
        appDao.getFavTvShow()

    fun getMovieDetail(movieId: Int): LiveData<MovieEntity> =
        appDao.getMovieDetail(movieId)

    fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity> =
        appDao.getTvShowDetail(tvShowId)

    fun insertMovies(movies: List<MovieEntity>) = appDao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvShowEntity>) = appDao.insertTvShows(tvShows)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        appDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        appDao.updateTvShow(tvShow)
    }
}
