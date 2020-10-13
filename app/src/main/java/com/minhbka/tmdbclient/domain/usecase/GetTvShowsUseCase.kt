package com.minhbka.tmdbclient.domain.usecase

import com.minhbka.tmdbclient.domain.repository.TvShowRepository


class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute() = tvShowRepository.getTvShows()
}