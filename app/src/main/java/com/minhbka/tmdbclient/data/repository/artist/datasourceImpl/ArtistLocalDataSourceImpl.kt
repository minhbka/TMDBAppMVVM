package com.minhbka.tmdbclient.data.repository.artist.datasourceImpl

import com.minhbka.tmdbclient.data.db.ArtistDao
import com.minhbka.tmdbclient.data.model.artist.Artist
import com.minhbka.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl (private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromDb() =  artistDao.getArtists()


    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}