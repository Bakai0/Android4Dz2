package com.example.kitsu_android4.repository

import com.example.kitsu_android4.base.BaseRepository
import com.example.kitsu_android4.data.remote.apiservise.TokenApiService
import com.example.kitsu_android4.model.login.LogDataModel
import javax.inject.Inject

class LogInRepository @Inject constructor(private val service: TokenApiService) :
    BaseRepository() {

        fun fetchToken(logDataModel: LogDataModel) = doRequest {
            service.fetchToken(logDataModel)
        }
}