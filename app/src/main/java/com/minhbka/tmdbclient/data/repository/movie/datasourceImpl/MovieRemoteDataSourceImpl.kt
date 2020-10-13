package com.minhbka.tmdbclient.data.repository.movie.datasourceImpl

import com.minhbka.tmdbclient.data.api.TMDBService
import com.minhbka.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String) :
    MovieRemoteDataSource {
    override suspend fun getMovies() = tmdbService.getPopularMovies(apiKey)

}