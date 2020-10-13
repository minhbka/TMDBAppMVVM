package com.minhbka.tmdbclient.data.repository.tvshow.datasourceImpl

import com.minhbka.tmdbclient.data.model.artist.Artist
import com.minhbka.tmdbclient.data.model.tvshow.TvShow
import com.minhbka.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.minhbka.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl() :
    TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(artists: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(artists)
    }
}