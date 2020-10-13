package com.minhbka.tmdbclient.presentation.di.core

import com.minhbka.tmdbclient.data.db.ArtistDao
import com.minhbka.tmdbclient.data.db.MovieDao
import com.minhbka.tmdbclient.data.db.TvShowDao
import com.minhbka.tmdbclient.data.model.tvshow.TvShow
import com.minhbka.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.minhbka.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.minhbka.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.minhbka.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.minhbka.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.minhbka.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.minhbka.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.minhbka.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.minhbka.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}