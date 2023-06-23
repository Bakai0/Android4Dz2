package com.example.kitsu_android4.data.remote.apiservise

import com.bumptech.glide.load.model.Model
import com.example.kitsu_android4.model.KitsuResponse
import com.example.kitsu_android4.model.anime.AnimeModel
import com.example.kitsu_android4.model.anime.DataModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiServise {

    @GET("anime")
    suspend fun fetchAnime(
    @Query("page[limit]") pageSize: Int,
    @Query("page[offset]") offset: Int
    ) : KitsuResponse<AnimeModel>

    @GET("anime/{id}")
    suspend fun fetchIdAnime(
        @Path("id") id: Int
    ): DataModel
}