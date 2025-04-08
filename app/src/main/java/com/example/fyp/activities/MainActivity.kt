package com.example.fyp.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.fyp.R
import com.example.fyp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var type : String = ""
    private val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setType()
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
            if (data == "player")
            {
                setupPlayer()
            }
            else if(data=="sponsor")
            {
                setupSponsor()
            }
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
                    setupPlayer()
                }
                else if(it=="sponsor")
                {
                    setupSponsor()
                }
                else
                {

                }
            }
        }

    }

    private fun setupSponsor() {
        Toast.makeText(this, "in sponsor", Toast.LENGTH_SHORT).show()
        val fragmentSponsor = findViewById<FragmentContainerView>(R.id.fcvSponsor)
        val fragmentPLayer = findViewById<FragmentContainerView>(R.id.fcvPLayer)

        binding.bnvPlayer.visibility = View.INVISIBLE
        fragmentPLayer.visibility = View.INVISIBLE

        binding.bnvSponsor.visibility = View.VISIBLE
        fragmentSponsor.visibility = View.VISIBLE


        val navHostFragment= supportFragmentManager.findFragmentById(R.id.fcvSponsor) as NavHostFragment
        val navController= navHostFragment.navController
        binding.bnvSponsor.setupWithNavController(navController)

        binding.bnvSponsor.setOnItemSelectedListener { menuItem ->
            if (navController.currentDestination?.id != menuItem.itemId) {
                navController.navigate(menuItem.itemId)
            }
            true
        }
    }

    private fun setupPlayer() {
        Toast.makeText(this, "in player", Toast.LENGTH_SHORT).show()
        val fragmentSponsor = findViewById<FragmentContainerView>(R.id.fcvSponsor)
        val fragmentPLayer = findViewById<FragmentContainerView>(R.id.fcvPLayer)

        binding.bnvSponsor.visibility = View.INVISIBLE
        fragmentSponsor.visibility = View.INVISIBLE

        binding.bnvPlayer.visibility = View.VISIBLE
        fragmentPLayer.visibility = View.VISIBLE


        val navHostFragment= supportFragmentManager.findFragmentById(R.id.fcvPLayer) as NavHostFragment
        val navController= navHostFragment.navController
        binding.bnvPlayer.setupWithNavController(navController)

        binding.bnvPlayer.setOnItemSelectedListener { menuItem ->
            if (navController.currentDestination?.id != menuItem.itemId) {
                navController.navigate(menuItem.itemId)
            }
            true
        }
    }
}