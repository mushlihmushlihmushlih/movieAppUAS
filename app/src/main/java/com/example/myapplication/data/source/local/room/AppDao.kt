package com.example.myapplication.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.myapplication.data.source.local.entity.MovieEntity
import com.example.myapplication.data.source.local.entity.TvShowEntity

@Dao
interface AppDao {
    @Query("SELECT * FROM movieentities")
    fun getMovies() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities WHERE isFavorite = 1")
    fun getFavMovies() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovieDetail(movieId: Int) : LiveData<MovieEntity>

    @Query("SELECT * FROM tvshowentities")
    fun getTvShow() : DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tvshowentities WHERE isFavorite = 1")
    fun getFavTvShow() : DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvShowId")
    fun getTvShowDetail(tvShowId: Int) : LiveData<TvShowEntity>

    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Update
    fun updateMovie(movie : MovieEntity)

    @Update
    fun updateTvShow(tvShows: TvShowEntity)

}