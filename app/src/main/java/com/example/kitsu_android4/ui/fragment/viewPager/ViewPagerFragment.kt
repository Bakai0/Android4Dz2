package com.example.kitsu_android4.ui.fragment.viewPager

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu_android4.R
import com.example.kitsu_android4.base.BaseFragment
import com.example.kitsu_android4.databinding.FragmentViewPagerBinding
import com.example.kitsu_android4.ui.adapter.AnimeViewPager
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerFragment : BaseFragment<FragmentViewPagerBinding, ViewPagerViewModel>(R.layout.fragment_view_pager) {

    override val binding by viewBinding( FragmentViewPagerBinding::bind)
    override val viewModel: ViewPagerViewModel by viewModels()

    private val fragListnames = listOf(
        "Anime",
        "Amnge"
    )

    override fun initialize() {
        val adapter = AnimeViewPager(this)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab,pos ->
            tab.text = fragListnames[pos]
        }.attach()
    }

}