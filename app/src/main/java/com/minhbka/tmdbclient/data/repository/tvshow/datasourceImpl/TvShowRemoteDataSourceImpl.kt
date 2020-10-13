package com.minhbka.tmdbclient.data.repository.tvshow.datasourceImpl

import com.minhbka.tmdbclient.data.api.TMDBService
import com.minhbka.tmdbclient.data.model.tvshow.TvShow
import com.minhbka.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.minhbka.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.minhbka.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String) :
    TvShowRemoteDataSource {
    override suspend fun getTvShows() = tmdbService.getPopularTvShows(apiKey)

}