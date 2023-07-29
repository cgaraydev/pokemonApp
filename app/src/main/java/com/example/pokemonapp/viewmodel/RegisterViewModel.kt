package com.example.pokemonapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pokemonapp.data.User
import com.example.util.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    private val _register = MutableStateFlow<Resource<FirebaseUser>>(Resource.Loading())
    val register: Flow<Resource<FirebaseUser>> = _register

    fun createAccount(user: User, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(user.email, password)
            .addOnSuccessListener {
                it.user?.let { firebaseUser ->
                    _register.value = Resource.Success(firebaseUser)
                }
            }.addOnFailureListener {
                _register.value = Resource.Error(it.message.toString())
            }
    }

}