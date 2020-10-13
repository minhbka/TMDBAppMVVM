package com.minhbka.tmdbclient.domain.repository

import com.minhbka.tmdbclient.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}