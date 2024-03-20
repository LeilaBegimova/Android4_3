package com.example.android4_1.data.remote.apiservises

import com.example.android4_1.data.remote.apiservises.models.MangaResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val POST_END_POINT = "manga"
private const val POST_END_POINT_ANIME = "anime"


interface MangaApi {

    @GET(POST_END_POINT)
    suspend fun getManga(
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") limit: Int,
    ): MangaResponse
    @GET(POST_END_POINT_ANIME)
    suspend fun getAnime(
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") limit: Int,
    ): MangaResponse
}

