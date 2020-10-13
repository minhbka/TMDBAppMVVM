package com.minhbka.tmdbclient.data.repository.tvshow.datasourceImpl

import com.minhbka.tmdbclient.data.db.ArtistDao
import com.minhbka.tmdbclient.data.db.TvShowDao
import com.minhbka.tmdbclient.data.model.artist.Artist
import com.minhbka.tmdbclient.data.model.tvshow.TvShow
import com.minhbka.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.minhbka.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl (private val tvShowDao: TvShowDao):
    TvShowLocalDataSource {
    override suspend fun getTvShowsFromDb() =  tvShowDao.getTvShows()


    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}