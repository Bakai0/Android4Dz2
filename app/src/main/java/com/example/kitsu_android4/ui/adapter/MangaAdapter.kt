package com.example.kitsu_android4.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsu_android4.ProgressTarget
import com.example.kitsu_android4.databinding.KitsuItemBinding
import com.example.kitsu_android4.model.manga.MangaModel

class MangaAdapter(private val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<MangaModel, MangaAdapter.MangaViewHolder>(diffUtil) {

    inner class MangaViewHolder(private val binding: KitsuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(absoluteAdapterPosition)
            }
        }

        fun onBind(mangaModel: MangaModel?) = with(binding) {

            textViewTitle.text = mangaModel?.attributes?.title?.title
            val progressTarget = ProgressTarget(binding.progressBar, binding.imageView)
            Glide.with(binding.imageView)
                .load(mangaModel?.attributes?.image?.image)
                .into(progressTarget)
        }
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder(
            KitsuItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<MangaModel>() {
            override fun areItemsTheSame(
                oldItem: MangaModel,
                newItem: MangaModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: MangaModel,
                newItem: MangaModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
