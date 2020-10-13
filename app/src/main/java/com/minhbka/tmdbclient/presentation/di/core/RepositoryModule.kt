package com.minhbka.tmdbclient.presentation.di.core

import com.minhbka.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.minhbka.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.minhbka.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.minhbka.tmdbclient.data.repository.artist.datasourceImpl.ArtistRepositoryImpl
import com.minhbka.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.minhbka.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.minhbka.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.minhbka.tmdbclient.data.repository.movie.datasourceImpl.MovieRepositoryImpl
import com.minhbka.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.minhbka.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.minhbka.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.minhbka.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRepositoryImpl
import com.minhbka.tmdbclient.domain.repository.ArtistRepository
import com.minhbka.tmdbclient.domain.repository.MovieRepository
import com.minhbka.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }
}