package com.example.kitsu_android4.di

import com.example.kitsu_android4.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideAnimeApiService(RetrofitClient: RetrofitClient) =
        RetrofitClient().provideAnimeApiService()

    @Singleton
    @Provides
    fun provideMangaApiService(RetrofitClient: RetrofitClient) =
        RetrofitClient().provideMangaApiService()

    @Singleton
    @Provides
    fun provideTokenApiService(RetrofitClient: RetrofitClient) =
        RetrofitClient().provideTokenApiService()

}