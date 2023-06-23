package com.example.kitsu_android4.model.anime

import com.google.gson.annotations.SerializedName
import com.example.kitsu_android4.model.anime.attributes.Attributes

data class AnimeModel(

    @SerializedName("id")
    val id: Int,
    @SerializedName("attributes")
    val attributes: Attributes
) {
}
