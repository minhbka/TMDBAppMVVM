package com.minhbka.tmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.minhbka.tmdbclient.R
import com.minhbka.tmdbclient.data.model.tvshow.TvShow
import com.minhbka.tmdbclient.databinding.ListItemBinding

class TvShowAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowList = ArrayList<TvShow>()
    fun setList(tvShows: List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount() = tvShowList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }
}
class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow: TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500${tvShow.poster_path}"
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }

}