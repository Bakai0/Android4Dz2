package com.example.kitsu_android4.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kitsu_android4.ui.fragment.kitsu.KitsuFragment
import com.example.kitsu_android4.ui.fragment.manga.MangaFragment

class AnimeViewPager(fragment: Fragment) : FragmentStateAdapter(fragment) {
    companion object{
        private const val NUM_TABS = 2
    }

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> KitsuFragment()
            1 -> MangaFragment()
            else -> throw java.lang.IllegalArgumentException("lol: $position")
        }
    }
}