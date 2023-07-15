package com.example.kitsu_android4.data.remote.intersepter

import okhttp3.Interceptor
import okhttp3.Response


const val accesstoken: String = "access_token"

class TokenInterseptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url =
            request.url.newBuilder()
                .addQueryParameter(
                    "Authorization:",
                "Bearer $accesstoken"
                )
                .build()
        request = request.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}