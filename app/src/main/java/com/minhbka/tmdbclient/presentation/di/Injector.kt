package com.minhbka.tmdbclient.presentation.di

import com.minhbka.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.minhbka.tmdbclient.presentation.di.movie.MovieSubComponent
import com.minhbka.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}