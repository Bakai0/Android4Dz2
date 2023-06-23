package com.example.kitsu_android4.base

import androidx.lifecycle.liveData
import com.example.kitsu_android4.utils.Resource

open class BaseRepository {

    protected open fun <T> doRequest(request: suspend () -> T) = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Succes(request()))
        } catch (exception: Exception) {
            emit(Resource.Error(null, exception.localizedMessage ?: "Error"))
        }
    }
}