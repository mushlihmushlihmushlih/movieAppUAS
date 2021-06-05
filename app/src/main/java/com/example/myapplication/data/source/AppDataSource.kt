package com.example.myapplication.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.myapplication.data.source.local.entity.MovieEntity
import com.example.myapplication.data.source.local.entity.TvShowEntity
import com.example.myapplication.vo.Resource

interface AppDataSource {

    fun getMovies(page: Int)
    : LiveData<Resource<PagedList<MovieEntity>>>

    fun getFavMovie() : LiveData<PagedList<MovieEntity>>

    fun getTvShow(page: Int)
    : LiveData<Resource<PagedList<TvShowEntity>>>

    fun getFavTvShow(): LiveData<PagedList<TvShowEntity>>

    fun getMovieDetail(movieId: Int)
    : LiveData<Resource<MovieEntity>>

    fun getTvShowDetail(tvShowId: Int)
    : LiveData<Resource<TvShowEntity>>

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean)
}