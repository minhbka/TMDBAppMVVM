package com.minhbka.tmdbclient.data.repository.tvshow.datasource

import com.minhbka.tmdbclient.data.model.tvshow.TvShow


interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(artists: List<TvShow>)
}