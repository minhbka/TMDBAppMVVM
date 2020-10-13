package com.minhbka.tmdbclient.data.repository.movie.datasourceImpl

import android.util.Log
import com.minhbka.tmdbclient.data.model.movie.Movie
import com.minhbka.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.minhbka.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.minhbka.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.minhbka.tmdbclient.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
):MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi():List<Movie>{
        lateinit var movieList:List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body!=null){
                movieList = body.movies
            }
        }
        catch (ex:Exception){
            Log.i("DEBUG", "Exception: ${ex.message}" )
        }
        return  movieList
    }

    suspend fun getMoviesFromDb():List<Movie>{
        lateinit var movieList:List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDb()
        }
        catch (ex:Exception){
            Log.i("DEBUG", "Exception: ${ex.message}" )
        }
        if (movieList.isNotEmpty()){
            return  movieList
        }
        else{
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return  movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList:List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }
        catch (ex:Exception){
            Log.i("DEBUG", "Exception: ${ex.message}" )
        }
        if (movieList.isNotEmpty()){
            return  movieList
        }
        else{
            movieList = getMoviesFromDb()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return  movieList
    }
}