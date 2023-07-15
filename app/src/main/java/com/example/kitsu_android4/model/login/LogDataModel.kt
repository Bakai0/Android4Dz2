package com.example.kitsu_android4.model.login

import com.google.gson.annotations.SerializedName

data class LogDataModel(

    @SerializedName("grant_type")
    val grant_type: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("password")
    val password: String
)
