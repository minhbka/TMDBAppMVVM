package com.minhbka.tmdbclient.domain.usecase

import com.minhbka.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase (private val movieRepository: MovieRepository){
    suspend fun execute() = movieRepository.updateMovies()
}