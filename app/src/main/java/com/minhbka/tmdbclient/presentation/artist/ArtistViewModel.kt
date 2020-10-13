package com.minhbka.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.minhbka.tmdbclient.domain.usecase.GetArtistsUseCase
import com.minhbka.tmdbclient.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel(){
    fun getArtists() = liveData {
        val movieList = getArtistsUseCase.execute()
        emit(movieList)
    }

    fun updateArtists() = liveData {
        val movieList = updateArtistsUseCase.execute()
        emit(movieList)
    }
}