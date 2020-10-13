package com.minhbka.tmdbclient.data.repository.movie.datasource

import com.minhbka.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}