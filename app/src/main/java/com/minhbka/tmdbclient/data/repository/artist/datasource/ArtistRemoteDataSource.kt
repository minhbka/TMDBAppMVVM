package com.minhbka.tmdbclient.data.repository.artist.datasource

import com.minhbka.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists():Response<ArtistList>
}