package com.minhbka.tmdbclient.data.db

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.minhbka.tmdbclient.data.model.tvshow.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("DELETE from popular_tvshows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * from popular_tvshows")
    suspend fun getTvShows(): List<TvShow>
}