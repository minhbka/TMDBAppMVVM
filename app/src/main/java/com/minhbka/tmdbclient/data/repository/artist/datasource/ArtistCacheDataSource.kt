package com.minhbka.tmdbclient.data.repository.artist.datasource

import com.minhbka.tmdbclient.data.model.artist.Artist


interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}