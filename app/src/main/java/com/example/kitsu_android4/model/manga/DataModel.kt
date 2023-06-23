package com.example.kitsu_android4.model.manga

import com.google.gson.annotations.SerializedName

data class DataModel(

    @SerializedName("data")
    val animeModel: MangaModel
)