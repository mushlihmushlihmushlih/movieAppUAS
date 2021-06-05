package com.example.myapplication.ui.series

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.source.local.entity.TvShowEntity
import com.example.myapplication.databinding.ItemsSeriesBinding
import com.example.myapplication.ui.detail.DetailTvShowActivity
import com.example.myapplication.utils.Helper

class SeriesAdapter : PagedListAdapter<TvShowEntity, SeriesAdapter.SeriesViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }
            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class SeriesViewHolder(private val binding: ItemsSeriesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(series: TvShowEntity) {
            with(binding) {
                tvItemTitleSeries.text = series.name
                tvItemDescriptionSeries.text = series.desc

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_DATA, series.tvShowId)
                    itemView.context.startActivity(intent)
                }
                series.poster.let {
                    Helper.setImageWithGlide(
                        itemView.context,
                        Helper.API_IMAGE_ENDPOINT + Helper.ENDPOINT_POSTER_SIZE_W185 + it,
                        imgPosterSeries
                    )
                }


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val itemsSeriesBinding = ItemsSeriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeriesViewHolder(itemsSeriesBinding)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val series = getItem(position)
        if (series != null){
            holder.bind(series)
        }
    }

}