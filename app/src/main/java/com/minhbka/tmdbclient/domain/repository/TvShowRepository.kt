package com.minhbka.tmdbclient.domain.repository

import com.minhbka.tmdbclient.data.model.tvshow.TvShow


interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}