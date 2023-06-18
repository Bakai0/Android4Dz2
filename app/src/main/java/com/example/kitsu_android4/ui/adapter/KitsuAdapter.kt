package com.example.kitsu_android4.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsu_android4.databinding.KitsuItemBinding
import com.example.kitsu_android4.model.anime.AnimeModel


class KitsuAdapter(private val onItemClick: (id: Int) -> Unit):
ListAdapter<AnimeModel, KitsuAdapter.KitsuViewHolder>(diffUtil) {

    inner class KitsuViewHolder(private val binding: KitsuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(animeModel: AnimeModel?) {
            Glide.with(binding.imageView).load(animeModel?.attributes?.image?.image)
                .into(binding.imageView)
            binding.textViewTitle.text = animeModel?.attributes?.title?.title
        }

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitsuViewHolder {
        return KitsuViewHolder(
            KitsuItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: KitsuViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<AnimeModel>() {
            override fun areItemsTheSame(
                oldItem: AnimeModel,
                newItem: AnimeModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: AnimeModel,
                newItem: AnimeModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}


