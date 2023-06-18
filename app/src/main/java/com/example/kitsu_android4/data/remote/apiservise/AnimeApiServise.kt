package com.example.kitsu_android4.data.remote.apiservise

import com.example.kitsu_android4.model.KitsuResponse
import com.example.kitsu_android4.model.anime.AnimeModel
import com.example.kitsu_android4.model.anime.DataModel
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiServise {

    @GET("anime")
    suspend fun fetchAnime(): KitsuResponse<AnimeModel>

    @GET("anime/{id}")
    suspend fun fetchIdAnime(
        @Path("id") id: Int
    ): DataModel
}