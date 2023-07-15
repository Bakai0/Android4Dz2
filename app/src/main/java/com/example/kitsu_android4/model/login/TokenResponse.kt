package com.example.kitsu_android4.model.login

import com.google.gson.annotations.SerializedName

data class TokenResponse
    (
    @SerializedName("access_token")
    val access_token: String,
    @SerializedName("created_at")
    val created_at: Int,
    @SerializedName("expires_in")
    val expires_in: Int,
    @SerializedName("refresh_token")
    val refresh_token: String,
    @SerializedName("token_type")
    val token_type: String
)
