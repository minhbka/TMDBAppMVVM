package com.minhbka.tmdbclient.data.repository.artist.datasourceImpl

import com.minhbka.tmdbclient.data.api.TMDBService
import com.minhbka.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.minhbka.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String) :
    ArtistRemoteDataSource {
    override suspend fun getArtists() = tmdbService.getPopularArtists(apiKey)

}