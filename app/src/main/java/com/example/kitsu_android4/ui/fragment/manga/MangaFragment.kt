package com.example.kitsu_android4.ui.fragment.manga

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu_android4.R
import com.example.kitsu_android4.base.BaseFragment
import com.example.kitsu_android4.databinding.FragmentMangaBinding
import com.example.kitsu_android4.ui.adapter.MangaAdapter
import com.example.kitsu_android4.ui.fragment.home.HomeFragmentDirections
import kotlinx.coroutines.launch

class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter(this::onClick)

    private fun onClick(id: Int) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToMangaDetailFragment(
                id.plus(1)
            )
        )
    }

    override fun initialize() {
        super.initialize()
        binding.recyclerViewManga.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = mangaAdapter
        }
    }

    override fun setupSubscribes() {
        super.setupSubscribes()
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        lifecycleScope.launch {
            viewModel.fetchManga().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    mangaAdapter.submitData(it)
                    Log.e("activity", it.toString())
                }
            }
        }
    }
}