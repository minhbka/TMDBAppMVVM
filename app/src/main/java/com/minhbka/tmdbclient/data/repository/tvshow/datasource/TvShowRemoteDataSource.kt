package com.minhbka.tmdbclient.data.repository.tvshow.datasource

import com.minhbka.tmdbclient.data.model.artist.ArtistList
import com.minhbka.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows():Response<TvShowList>
}