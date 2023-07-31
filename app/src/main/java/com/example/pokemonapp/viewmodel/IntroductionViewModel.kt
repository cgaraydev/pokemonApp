package com.example.pokemonapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroductionViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
//    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    private val _navigate = MutableStateFlow(0)
    val navigate: StateFlow<Int> = _navigate

    companion object {
        const val POKEMON_ACTIVITY = 23
    }

    init {
//        val isUserLoggedIn = sharedPreferences.getBoolean("Introduction", false)
        val user = firebaseAuth.currentUser

        if (user != null) {
            viewModelScope.launch {
                _navigate.emit(POKEMON_ACTIVITY)
            }
        }
//        if (isUserLoggedIn){
//            viewModelScope.launch {
//                _navigate.emit(POKEMON_ACTIVITY)
//            }
//        }
    }

//    fun userLoggedIn() {
//        sharedPreferences.edit().putBoolean("Introduction", true).apply()
//    }
}