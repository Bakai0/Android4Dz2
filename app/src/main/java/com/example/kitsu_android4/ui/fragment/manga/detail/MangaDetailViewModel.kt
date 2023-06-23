package com.example.kitsu_android4.ui.fragment.manga.detail

import androidx.lifecycle.ViewModel
import com.example.kitsu_android4.base.BaseViewModel
import com.example.kitsu_android4.repository.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel
 @Inject constructor(private val repository: MangaRepository) :
    BaseViewModel() {

    fun fetchMangaById(id: Int) = repository.fetchMangaById(id)
}