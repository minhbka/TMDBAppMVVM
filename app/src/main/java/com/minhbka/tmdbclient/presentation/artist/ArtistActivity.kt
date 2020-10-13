package com.minhbka.tmdbclient.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.minhbka.tmdbclient.R
import com.minhbka.tmdbclient.data.model.artist.Artist
import com.minhbka.tmdbclient.databinding.ActivityArtistBinding
import com.minhbka.tmdbclient.presentation.di.Injector
import com.minhbka.tmdbclient.presentation.movies.MovieAdapter
import com.minhbka.tmdbclient.presentation.movies.MovieViewModel
import com.minhbka.tmdbclient.presentation.movies.MovieViewModelFactory
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory

    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter
    private lateinit var binding:ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent()
            .inject(this)
        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)
        initRecycleView()
    }

    private fun initRecycleView(){
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE

            }
            else{
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data available", Toast.LENGTH_LONG).show()
            }


        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val response = artistViewModel.updateArtists()
        response.observe(this, Observer {
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                binding.artistProgressBar.visibility = View.GONE

            }
        })
    }
}