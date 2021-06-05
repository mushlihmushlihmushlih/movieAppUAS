package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.data.source.AppRepository
import com.example.myapplication.data.source.local.LocalDataSource
import com.example.myapplication.data.source.local.room.AppDatabase
import com.example.myapplication.data.source.remote.RemoteDataSource
import com.example.myapplication.utils.AppExecutors

object Injection {
    fun provideAppRepository(context: Context): AppRepository {
        val database = AppDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.appDao())
        val appExecutors = AppExecutors()
        return AppRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}