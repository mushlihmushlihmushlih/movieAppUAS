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
import com.example.myapplication.ui.movie.MovieAdapter
import com.example.myapplication.viewmodel.ViewModelFactory


class MovieFavoriteFragment : Fragment() {

    private lateinit var binding: FragmentMovieFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val favMovieViewModel = ViewModelProvider(this, factory)[MovieFavoriteViewModel::class.java]
            val adapter = MovieAdapter()

            binding.progressBar.visibility = View.VISIBLE
            favMovieViewModel.getFavoriteMovie().observe(viewLifecycleOwner,{
                if (it != null){
                    binding.progressBar.visibility = View.GONE
                    adapter.submitList(it)
                }else{
                    binding.tvNotFound.visibility = View.VISIBLE
                }
            })

            with(binding.rvMoviesFavorite){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

}