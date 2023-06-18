package com.example.kitsu_android4.data.remote

import com.example.kitsu_android4.data.remote.apiservise.AnimeApiServise
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/edge/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideAnimeApiService(): AnimeApiServise {
        return retrofitClient.create(AnimeApiServise::class.java)
    }
}