package com.example.kitsu_android4.ui.fragment.kitsu.detail

import androidx.lifecycle.ViewModel
import com.example.kitsu_android4.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: AnimeRepository) :
    ViewModel() {

    fun fetchIdAnime(id: Int) = repository.fetchIdAnime(id)
}