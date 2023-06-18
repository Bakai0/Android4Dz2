package com.example.kitsu_android4.model.anime.attributes

import com.example.kitsu_android4.model.anime.attributes.image.Image
import com.example.kitsu_android4.model.anime.attributes.title.Title
import com.google.gson.annotations.SerializedName

data class Attributes(

    @SerializedName("synopsis")
    val detail: String,
    @SerializedName("titles")
    val title: Title,
    @SerializedName("posterImage")
    val image: Image
)
