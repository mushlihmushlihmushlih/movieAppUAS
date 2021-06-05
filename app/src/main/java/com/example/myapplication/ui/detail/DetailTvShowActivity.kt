package com.example.myapplication.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.source.local.entity.TvShowEntity
import com.example.myapplication.databinding.ContentDetailBinding
import com.example.myapplication.utils.Helper
import com.example.myapplication.viewmodel.ViewModelFactory
import com.example.myapplication.vo.Status

class DetailTvShowActivity : AppCompatActivity() {
    val TAG = "DetailActivity"
    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var viewModel: DetailTvShowViewModel
    private var menu: Menu? = null

    private lateinit var detailContentBinding: ContentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailContentBinding = ContentDetailBinding.inflate(layoutInflater)
        setContentView(detailContentBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getInt(EXTRA_DATA)
            viewModel.setSelectedTvShow(tvShowId)
            viewModel.getTvShowDetail.observe(this, { tvShow ->
                if (tvShow != null) {
                    when (tvShow.status) {
                        Status.LOADING -> Toast.makeText(applicationContext, "Loading", Toast.LENGTH_SHORT).show()
                        Status.SUCCESS -> if (tvShow.data != null) {
                            showDetail(tvShow.data)
                        }
                        Status.ERROR -> Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

    private fun showDetail(tvShow: TvShowEntity) {
        detailContentBinding.textTitle.text = tvShow.name
        detailContentBinding.textDescription.text = tvShow.desc
        supportActionBar!!.title = tvShow.name

        Helper.setImageWithGlide(
            this,
            Helper.API_IMAGE_ENDPOINT + Helper.ENDPOINT_POSTER_SIZE_W185 + tvShow.poster,
            detailContentBinding.imagePoster
        )

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_content,menu)
        this.menu = menu
        viewModel.getTvShowDetail.observe(this, {tvShow->
            if (tvShow != null) {
                when (tvShow.status) {
                    Status.SUCCESS -> if (tvShow.data != null) {
                        val state = tvShow.data.isFavorite
                        isFavButtonActive(state)
                    }
                    Status.ERROR -> {
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.btn_favorite) {
            viewModel.setAsFavTvShow()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun isFavButtonActive(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.btn_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }
    }


}