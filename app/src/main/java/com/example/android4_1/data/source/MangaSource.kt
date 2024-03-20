package com.example.android4_1.data.source

import android.net.Uri
import androidx.core.net.toUri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android4_1.data.remote.apiservises.MangaApi
import com.example.android4_1.data.remote.apiservises.models.Data
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException


private const val START_KEY = 1
private const val LOAD_DELAY_MILLS = 3_000L

class MangaSource(
    private val mangaApiService: MangaApi
) :
    PagingSource<Int, Data>() {

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        try {
            val nextPageNumber = params.key ?: 1
            val response = mangaApiService.getManga(nextPageNumber, params.loadSize)
            val data = response.data
            val prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1
            val nextKey = if (data.isNotEmpty()) nextPageNumber + 1 else null

            return LoadResult.Page(data = data, prevKey = prevKey, nextKey = nextKey)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}