package com.minhbka.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.minhbka.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.minhbka.tmdbclient.domain.usecase.UpdateTvShowsUseCase

@Suppress("UNCHECKED_CAST")
class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  TvShowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}