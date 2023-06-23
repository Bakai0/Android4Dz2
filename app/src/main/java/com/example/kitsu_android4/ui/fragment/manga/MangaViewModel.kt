package com.example.kitsu_android4.ui.fragment.manga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.kitsu_android4.base.BaseViewModel
import com.example.kitsu_android4.repository.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(private val repository: MangaRepository) :
    BaseViewModel() {

    fun fetchManga() = repository.fetchManga().cachedIn(viewModelScope)
}