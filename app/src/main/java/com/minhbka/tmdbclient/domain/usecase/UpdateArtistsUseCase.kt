package com.minhbka.tmdbclient.domain.usecase

import com.minhbka.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase (private val artistRepository: ArtistRepository){
    suspend fun execute() = artistRepository.updateArtists()
}