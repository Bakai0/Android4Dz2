package com.example.kitsu_android4.ui.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.kitsu_android4.R
import com.example.kitsu_android4.base.BaseFragment
import com.example.kitsu_android4.databinding.FragmentDetailBinding
import com.example.kitsu_android4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>(R.layout.fragment_detail) {

    override val binding by viewBinding(FragmentDetailBinding::bind)
    override val viewModel: DetailViewModel by viewModels()

    override fun setupSubscribes() {
        super.setupSubscribes()
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        val args by navArgs<DetailFragmentArgs>()
        viewModel.fetchIdAnime(args.id + 1).observe(requireActivity()) {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                }
                is Resource.Succes -> {
                    binding.textViewDetail.text = it.data?.animeModel?.attributes?.detail
                    Glide.with(binding.imageViewPoster)
                        .load(it.data?.animeModel?.attributes?.image?.image)
                        .into(binding.imageViewPoster)
                    binding.textView.text = it.data?.animeModel?.attributes?.title?.title
                }
            }
        }
    }
}