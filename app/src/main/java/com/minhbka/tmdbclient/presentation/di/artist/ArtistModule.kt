package com.minhbka.tmdbclient.presentation.di.artist

import com.minhbka.tmdbclient.domain.usecase.GetArtistsUseCase
import com.minhbka.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.minhbka.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}