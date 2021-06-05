package com.example.myapplication.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMovieFavoriteBinding
import com.example.myapplication.databinding.FragmentSeriesFavoriteBinding
import com.example.myapplication.ui.movie.MovieAdapter
import com.example.myapplication.ui.series.SeriesAdapter
import com.example.myapplication.viewmodel.ViewModelFactory


class SeriesFavoriteFragment : Fragment() {

    private lateinit var binding: FragmentSeriesFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSeriesFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val favMovieViewModel = ViewModelProvider(this, factory)[SeriesFavoriteViewModel::class.java]
            val adapter = SeriesAdapter()

            binding.progressBar.visibility = View.VISIBLE
            favMovieViewModel.getFavoriteTvShow().observe(viewLifecycleOwner,{
                if (it != null){
                    binding.progressBar.visibility = View.GONE
                    adapter.submitList(it)
                }else{
                    binding.tvNotFound.visibility = View.VISIBLE
                }
            })

            with(binding.rvSeriesFavorite){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

}