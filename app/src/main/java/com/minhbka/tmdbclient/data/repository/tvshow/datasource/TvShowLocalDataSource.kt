package com.minhbka.tmdbclient.data.repository.tvshow.datasource

import com.minhbka.tmdbclient.data.model.artist.Artist
import com.minhbka.tmdbclient.data.model.tvshow.TvShow


interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDb():List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}