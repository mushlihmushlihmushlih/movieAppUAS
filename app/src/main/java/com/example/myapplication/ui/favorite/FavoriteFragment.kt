package com.example.myapplication.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.ui.SectionsPagerAdapter
import com.example.myapplication.databinding.FragmentFavoriteBinding
import com.google.android.material.tabs.TabLayoutMediator

class FavoriteFragment : Fragment() {

    private lateinit var favoriteBinding: FragmentFavoriteBinding
    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter

    companion object{
        private val TITLES = intArrayOf(
            R.string.tab_title_movie,
            R.string.tab_title_tvshow
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        favoriteBinding =  FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return favoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sectionsPagerAdapter = SectionsPagerAdapter(requireActivity() as AppCompatActivity, childFragmentManager)

        favoriteBinding.viewPager.adapter = sectionsPagerAdapter
        val tabs = favoriteBinding.tabs
        TabLayoutMediator(tabs, favoriteBinding.viewPager) { tab, position ->
            tab.text = resources.getString(TITLES[position])
        }.attach()
    }




}