package com.minhbka.tmdbclient.data.repository.tvshow.datasourceImpl

import android.util.Log
import com.minhbka.tmdbclient.data.model.artist.Artist
import com.minhbka.tmdbclient.data.model.tvshow.TvShow
import com.minhbka.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.minhbka.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.minhbka.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.minhbka.tmdbclient.domain.repository.ArtistRepository
import com.minhbka.tmdbclient.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromApi():List<TvShow>{
        lateinit var tvShowList:List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body!=null){
                tvShowList = body.tvShows
            }
        }
        catch (ex:Exception){
            Log.i("DEBUG", "Exception: ${ex.message}" )
        }
        return  tvShowList
    }

    suspend fun getTvShowsFromDb():List<TvShow>{
        lateinit var tvShowList:List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDb()
        }
        catch (ex:Exception){
            Log.i("DEBUG", "Exception: ${ex.message}" )
        }
        if (tvShowList.isNotEmpty()){
            return  tvShowList
        }
        else{
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return  tvShowList
    }

    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowList:List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }
        catch (ex:Exception){
            Log.i("DEBUG", "Exception: ${ex.message}" )
        }
        if (tvShowList.isNotEmpty()){
            return  tvShowList
        }
        else{
            tvShowList = getTvShowsFromDb()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return  tvShowList
    }
}