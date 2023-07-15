package com.example.kitsu_android4.data.remote.apiservise

import com.example.kitsu_android4.model.login.LogDataModel
import com.example.kitsu_android4.model.login.TokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface TokenApiService {

    @POST("oauth/token")
    suspend fun fetchToken(
        @Body request: LogDataModel
    ) : TokenResponse
}