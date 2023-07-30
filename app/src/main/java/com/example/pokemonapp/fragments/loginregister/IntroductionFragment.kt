package com.example.pokemonapp.fragments.loginregister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentIntroductionBinding

class IntroductionFragment: Fragment() {

    private lateinit var binding: FragmentIntroductionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIntroductionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnLoginIntroduction.setOnClickListener {
                findNavController().navigate(R.id.action_introductionFragment_to_loginFragment)
            }
            btnRegisterIntroduction.setOnClickListener {
                findNavController().navigate(R.id.action_introductionFragment_to_registerFragment)
            }
        }
    }
}