package com.minhbka.tmdbclient.data.repository.movie.datasource

import com.minhbka.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movie: List<Movie>)
}