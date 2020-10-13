package com.minhbka.tmdbclient.domain.usecase

import com.minhbka.tmdbclient.data.model.movie.Movie
import com.minhbka.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}