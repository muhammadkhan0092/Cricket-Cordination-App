package com.example.fyp.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fyp.R
import com.example.fyp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var type : String = ""
    private val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setType()
        setupNavigationBar()
    }

    private fun setupNavigationBar() {
        val colorStateList = ContextCompat.getColorStateList(this,R.color.main_selection)
        binding.bottomNavView.itemIconTintList = colorStateList
        val navController = findNavController(R.id.fragmentContainerView)
        binding.bottomNavView.setupWithNavController(navController)
    }

    fun updateData(newValue: String) {
        _data.value = newValue
    }
    private fun setType() {
        val data = intent.getStringExtra("type")
        val sharedPreferences = getSharedPreferences("mydata", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        if (data != null) {
            updateData(data)
            Log.d("khan","recevied type as :${type}")
            editor.putString("type", data)
            editor.apply()
        }
        else
        {
            val t = sharedPreferences.getString("type", "")
            Log.d("khan","type is ${type}")
            t?.let {
                updateData(it)
                Log.d("khan","recevied type as :${type}")
                if (it == "player")
                {

                }
                else if(it=="sponsor")
                {
                }
                else
                {

                }
            }
        }

    }
}