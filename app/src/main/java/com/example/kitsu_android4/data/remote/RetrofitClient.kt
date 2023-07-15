package com.example.kitsu_android4.data.remote

import com.example.kitsu_android4.data.remote.apiservise.AnimeApiServise
import com.example.kitsu_android4.data.remote.apiservise.MangaApiService
import com.example.kitsu_android4.data.remote.apiservise.TokenApiService
import com.example.kitsu_android4.data.remote.intersepter.TokenInterseptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okkHttClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(loggingIterseptor())
        .addInterceptor(TokenInterseptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun loggingIterseptor() = HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY
    )

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/")
        .client(okkHttClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideAnimeApiService() =
        retrofitClient.create(AnimeApiServise::class.java)

    fun provideMangaApiService() =
        retrofitClient.create(MangaApiService::class.java)

    fun provideTokenApiService() =
        retrofitClient.create(TokenApiService::class.java)
}

