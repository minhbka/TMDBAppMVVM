package com.minhbka.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.minhbka.tmdbclient.data.db.ArtistDao
import com.minhbka.tmdbclient.data.db.MovieDao
import com.minhbka.tmdbclient.data.db.TMDBDatabase
import com.minhbka.tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideMovieDatabase(context:Context):TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }
    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase):TvShowDao{
        return tmdbDatabase.tvDao()
    }
    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase):ArtistDao{
        return tmdbDatabase.artistDao()
    }
}