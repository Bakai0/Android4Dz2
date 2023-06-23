package com.example.kitsu_android4.data.remote.apiservise

import com.bumptech.glide.load.model.Model
import com.example.kitsu_android4.model.KitsuResponse
import com.example.kitsu_android4.model.manga.DataModel
import com.example.kitsu_android4.model.manga.MangaModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(
        @Query("page[limit]") pageSize: Int,
        @Query("page[offset]") offset: Int
    ): KitsuResponse<MangaModel>

    @GET("manga/{id}")
    suspend fun fetchMangaById(
        @Path("id") id: Int
    ): DataModel
}