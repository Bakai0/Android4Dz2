package com.example.kitsu_android4.model

import com.google.gson.annotations.SerializedName

data class KitsuResponse<T>(

    @SerializedName("links")
    val links: Links,
    @SerializedName("data")
    val data: List<T>

) {
}