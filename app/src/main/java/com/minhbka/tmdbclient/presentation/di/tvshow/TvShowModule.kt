package com.minhbka.tmdbclient.presentation.di.tvshow

import com.minhbka.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.minhbka.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.minhbka.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}