package com.minhbka.tmdbclient.domain.repository

import com.minhbka.tmdbclient.data.model.artist.Artist


interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}