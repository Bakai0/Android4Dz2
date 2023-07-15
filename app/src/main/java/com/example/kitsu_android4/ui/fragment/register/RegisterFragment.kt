package com.example.kitsu_android4.ui.fragment.register

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu_android4.R
import com.example.kitsu_android4.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {

    private val binding by viewBinding(FragmentRegisterBinding::bind)

}