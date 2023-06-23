package com.example.kitsu_android4.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu_android4.R
import com.example.kitsu_android4.databinding.FragmentHomeBinding
import com.example.kitsu_android4.ui.adapter.HomeAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout()
    }

    private fun tabLayout() = with(binding) {
        viewPager.adapter = HomeAdapter(this@HomeFragment)
        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.text = "Anime"
                }
                1 -> {
                    tab.text = "Manga"
                }
            }
        }.attach()
    }
}
