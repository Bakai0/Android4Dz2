package com.example.kitsu_android4.ui.fragment.kitsu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.kitsu_android4.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KitsuViewModel @Inject constructor(private val repository: AnimeRepository): ViewModel() {

    fun fetchAnime() = repository.fetchAnime().cachedIn(viewModelScope)
}