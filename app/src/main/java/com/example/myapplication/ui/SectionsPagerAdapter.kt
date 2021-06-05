package com.example.myapplication.ui

import android.content.Context
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.ui.favorite.MovieFavoriteFragment
import com.example.myapplication.ui.favorite.SeriesFavoriteFragment
import com.example.myapplication.ui.movie.MovieFragment
import com.example.myapplication.ui.series.SeriesFragment

class SectionsPagerAdapter(private val activity: AppCompatActivity, fragment: FragmentManager)
    : FragmentStateAdapter(activity)  {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = MovieFavoriteFragment()
            1 -> fragment = SeriesFavoriteFragment()
        }
        return fragment as Fragment
    }
}