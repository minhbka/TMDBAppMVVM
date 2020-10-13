package com.minhbka.tmdbclient.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.minhbka.tmdbclient.domain.usecase.GetMoviesUseCase
import com.minhbka.tmdbclient.domain.usecase.UpdateMoviesUseCase

@Suppress("UNCHECKED_CAST")
class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  MovieViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}