package com.example.kitsu_android4.ui.fragment

import android.content.ContentValues.TAG
import android.nfc.Tag
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu_android4.R
import com.example.kitsu_android4.base.BaseFragment
import com.example.kitsu_android4.databinding.FragmentKitsuBinding
import com.example.kitsu_android4.ui.adapter.KitsuAdapter
import com.example.kitsu_android4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KitsuFragment  : BaseFragment<FragmentKitsuBinding, KitsuViewModel>(R.layout.fragment_kitsu) {

    override val binding by viewBinding(FragmentKitsuBinding::bind)
    override val viewModel: KitsuViewModel by viewModels()
    private val animeAdapter = KitsuAdapter(this::onClick)

    private fun onClick(id: Int) {
        findNavController().navigate(
            KitsuFragmentDirections.actionKitsuFragmentToDetailFragment(id)
        )
    }

    override fun initialize() {
        super.initialize()
        binding.recyclerViewKitsu.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun setupSubscribes() {
        super.setupSubscribes()
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        viewModel.fetchAnime().observe(requireActivity()) {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                    Log.e(TAG, "error")
                }
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                    Log.e(TAG, "loading")
                }
                is Resource.Succes -> {
                    animeAdapter.submitList(it.data?.animeList)
                }
            }
        }
    }
}






