package com.minhbka.tmdbclient.data.db

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.minhbka.tmdbclient.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artist: List<Artist>)

    @Query("DELETE from popular_artists")
    suspend fun deleteAllArtists()

    @Query("SELECT * from popular_artists")
    suspend fun getArtists(): List<Artist>
}