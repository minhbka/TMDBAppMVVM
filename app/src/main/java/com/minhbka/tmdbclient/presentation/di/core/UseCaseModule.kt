package com.minhbka.tmdbclient.presentation.di.core

import com.minhbka.tmdbclient.domain.repository.ArtistRepository
import com.minhbka.tmdbclient.domain.repository.MovieRepository
import com.minhbka.tmdbclient.domain.repository.TvShowRepository
import com.minhbka.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module
class UseCaseModule {


    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }


    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }


    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)
    }


    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistRepository)
    }


    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository):GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowRepository)
    }


    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository):UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowRepository)
    }
}