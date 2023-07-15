package com.example.kitsu_android4.ui.fragment.register.login

import com.example.kitsu_android4.base.BaseViewModel
import com.example.kitsu_android4.model.login.LogDataModel
import com.example.kitsu_android4.repository.LogInRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LogInRepository): BaseViewModel() {

    fun fetchToken(logDataModel: LogDataModel) = repository.fetchToken(logDataModel)

}