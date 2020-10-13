package com.minhbka.tmdbclient.domain.usecase

import com.minhbka.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase (private val tvShowRepository: TvShowRepository){
    suspend fun execute() = tvShowRepository.updateTvShows()
}