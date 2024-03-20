package com.example.android4_1.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.android4_1.data.remote.apiservises.MangaApi
import com.example.android4_1.data.remote.apiservises.models.Data
import com.example.android4_1.data.source.AnimeSourse
import com.example.android4_1.data.source.MangaSource
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApi
) {
    fun fetchManga(): LiveData<PagingData<Data>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { MangaSource(mangaApiService) }
        ).liveData
    }
    fun fetchAnime(): LiveData<PagingData<Data>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { AnimeSourse(mangaApiService) }
        ).liveData
    }
}