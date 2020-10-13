package com.minhbka.tmdbclient.data.db

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.minhbka.tmdbclient.data.model.movie.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE from popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * from popular_movies")
    suspend fun getMovies():List<Movie>
}