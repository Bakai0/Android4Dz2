package com.example.kitsu_android4.ui.fragment.home

import androidx.fragment.app.Fragment
import com.example.kitsu_android4.R
import com.example.kitsu_android4.utils.PrefernceHelper

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onDestroyView() {
        super.onDestroyView()
        setPreferenceData()
    }

    private fun setPreferenceData() {
        val preferenceHelper = PrefernceHelper()
        preferenceHelper.unit(requireContext())
        preferenceHelper.saveBoolean = true
    }
}

