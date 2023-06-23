package com.example.kitsu_android4.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.kitsu_android4.base.BaseRepository
import com.example.kitsu_android4.data.remote.apiservise.AnimeApiServise
import com.example.kitsu_android4.repository.pagingSources.AnimePagingSources
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiServise)
    : BaseRepository(){

    fun fetchAnime() = Pager(
        PagingConfig(
            pageSize = 10,
            initialLoadSize = 20
        )
    ) {
        AnimePagingSources(service)
    }.liveData


    fun fetchIdAnime(id: Int) = doRequest {
        service.fetchIdAnime(id)
    }
}