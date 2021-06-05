package com.example.myapplication.ui.series

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.data.source.local.entity.TvShowEntity
import com.example.myapplication.databinding.FragmentSeriesBinding
import com.example.myapplication.ui.detail.DetailTvShowActivity
import com.example.myapplication.viewmodel.ViewModelFactory
import com.example.myapplication.vo.Status

class SeriesFragment : Fragment() {

    private lateinit var fragmentSeriesBinding: FragmentSeriesBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSeriesBinding = FragmentSeriesBinding.inflate(layoutInflater, container, false)
        return fragmentSeriesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val seriesViewModel = ViewModelProvider(this,factory)[SeriesViewModel::class.java]
            val seriesAdapter = SeriesAdapter()

            seriesViewModel.getSeries().observe(viewLifecycleOwner, {series ->
                if (series != null) {
                    when (series.status) {
                        Status.LOADING -> fragmentSeriesBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentSeriesBinding.progressBar.visibility = View.GONE
                            seriesAdapter.submitList(series.data)
                        }
                        Status.ERROR -> {
                            fragmentSeriesBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentSeriesBinding.rvSeries) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = seriesAdapter
            }
        }
    }
}