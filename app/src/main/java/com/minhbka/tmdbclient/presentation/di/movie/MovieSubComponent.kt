package com.minhbka.tmdbclient.presentation.di.movie

import com.minhbka.tmdbclient.presentation.artist.ArtistActivity
import com.minhbka.tmdbclient.presentation.movies.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}