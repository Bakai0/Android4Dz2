package com.example.kitsu_android4.model

import com.google.gson.annotations.SerializedName

data class Links(

    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("prev")
    val prev: String
)
