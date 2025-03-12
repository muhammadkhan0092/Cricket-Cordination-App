package com.example.fyp.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fyp.R
import com.example.fyp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigationBar()
    }

    private fun setupNavigationBar() {
        val colorStateList = ContextCompat.getColorStateList(this,R.color.main_selection)
        binding.bottomNavView.itemIconTintList = colorStateList
        val navController = findNavController(R.id.fragmentContainerView)
        binding.bottomNavView.setupWithNavController(navController)
    }
}