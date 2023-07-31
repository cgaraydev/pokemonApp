package com.example.pokemonapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.ActivityPokemonBinding
import com.google.firebase.auth.FirebaseAuth

class PokemonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.pokemonHostFragment)
        binding.bottomNavBar.setupWithNavController(navController)

//        binding.tvLogOut.setOnClickListener {
//            FirebaseAuth.getInstance().signOut()
//            val intent = Intent(this, LoginRegisterActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(intent)
//            getSharedPreferences("Introduction", MODE_PRIVATE).edit().remove("Introduction").apply()

//        }
    }


}