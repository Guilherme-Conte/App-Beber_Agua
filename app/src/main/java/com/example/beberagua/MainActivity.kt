package com.example.beberagua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.beberagua.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navController by lazy {
     supportFragmentManager.findFragmentById(R.id.
     fragmentContainerView2)!!.findNavController()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setupBottonNavigation()
        setContentView(binding.root)

    }

    private fun setupBottonNavigation(){
        with(binding.bottomNavigation){
            setupWithNavController(navController) }
    }
}