package com.example.pokemonapp.fragments.loginregister

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.pokemonapp.R
import com.example.pokemonapp.activities.PokemonActivity
import com.example.pokemonapp.databinding.FragmentIntroductionBinding
import com.example.pokemonapp.viewmodel.IntroductionViewModel
import com.example.pokemonapp.viewmodel.IntroductionViewModel.Companion.POKEMON_ACTIVITY
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class IntroductionFragment : Fragment() {

    private lateinit var binding: FragmentIntroductionBinding
    private val viewModel by viewModels<IntroductionViewModel>()

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

        lifecycleScope.launch {
            viewModel.navigate.collect {
                when (it) {
                    POKEMON_ACTIVITY -> {
                        Intent(requireActivity(), PokemonActivity::class.java).also { intent ->
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                        }
                    }
                    else -> Unit
                }
            }
        }

        binding.apply {
            btnLoginIntroduction.setOnClickListener {
//                viewModel.userLoggedIn()
                findNavController().navigate(R.id.action_introductionFragment_to_loginFragment)
            }
            btnRegisterIntroduction.setOnClickListener {
                findNavController().navigate(R.id.action_introductionFragment_to_registerFragment)
            }
        }
    }
}