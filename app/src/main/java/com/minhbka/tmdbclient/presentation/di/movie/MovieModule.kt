package com.minhbka.tmdbclient.presentation.di.movie

import com.minhbka.tmdbclient.domain.usecase.GetMoviesUseCase
import com.minhbka.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.minhbka.tmdbclient.presentation.movies.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}