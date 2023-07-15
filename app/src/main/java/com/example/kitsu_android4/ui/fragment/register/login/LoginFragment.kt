package com.example.kitsu_android4.ui.fragment.register.login

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu_android4.R
import com.example.kitsu_android4.base.BaseFragment
import com.example.kitsu_android4.databinding.FragmentLoginBinding
import com.example.kitsu_android4.model.login.LogDataModel
import com.example.kitsu_android4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(R.layout.fragment_login) {

    override val binding by viewBinding(FragmentLoginBinding::bind)
    override val viewModel: LoginViewModel by viewModels()



    override fun setupListener() {
        binding.btnSingin.setOnClickListener {
            viewModel.fetchToken(
                LogDataModel(
                    "password",
                    binding.etInputPassword.text.toString(),
                    binding.etInputLogin.text.toString()
                )
            ).observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Error -> {
                        Log.e("everythingNewsError", it.message.toString())
                    }

                    is Resource.Loading -> {
                        Log.e("EverythingNewsLoading", it.message.toString())
                    }

                    is Resource.Succes -> {
                        requireActivity().findNavController(R.id.fragment_container_main)
                            .navigate(R.id.action_registerFragment_to_mainFragment)
                    }

                }
            }
        }
    }
}
