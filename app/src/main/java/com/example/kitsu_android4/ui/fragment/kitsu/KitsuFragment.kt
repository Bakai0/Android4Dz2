package com.example.kitsu_android4.ui.fragment.kitsu

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu_android4.R
import com.example.kitsu_android4.base.BaseFragment
import com.example.kitsu_android4.databinding.FragmentKitsuBinding
import com.example.kitsu_android4.ui.adapter.KitsuAdapter
import com.example.kitsu_android4.ui.fragment.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class KitsuFragment : BaseFragment<FragmentKitsuBinding, KitsuViewModel>(R.layout.fragment_kitsu) {

    override val binding by viewBinding(FragmentKitsuBinding::bind)
    override val viewModel: KitsuViewModel by viewModels()
    private val kitsuAdapter = KitsuAdapter(this::onClick)

    private fun onClick(id: Int) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailAnimeFragment(
                id.plus(1)
            )
        )
    }


    override fun initialize() {
        super.initialize()
        binding.recyclerViewAnime.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = kitsuAdapter
        }
    }

    override fun setupSubscribes() {
        super.setupSubscribes()
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        lifecycleScope.launch {
            viewModel.fetchAnime().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    kitsuAdapter.submitData(it)
                    Log.e("activity", it.toString())
                }
            }
        }
    }
}






