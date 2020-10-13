package com.minhbka.tmdbclient.data.repository.artist.datasource

import com.minhbka.tmdbclient.data.model.artist.Artist


interface ArtistLocalDataSource {
    suspend fun getArtistsFromDb():List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}