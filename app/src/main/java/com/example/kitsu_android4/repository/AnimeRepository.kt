package com.example.kitsu_android4.repository

import androidx.lifecycle.liveData
import com.example.kitsu_android4.data.remote.apiservise.AnimeApiServise
import com.example.kitsu_android4.utils.Resource
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiServise) {

    fun fetchAnime() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Succes(service.fetchAnime()))
        } catch (exception: Exception) {
            emit(Resource.Error(null, exception.localizedMessage ?: "Error"))
        }
    }

    fun fetchIdAnime(id: Int) = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Succes(service.fetchIdAnime(id)))
        } catch (exception: Exception) {
            emit(Resource.Error(null, exception.localizedMessage ?: "Error"))
        }
    }
}