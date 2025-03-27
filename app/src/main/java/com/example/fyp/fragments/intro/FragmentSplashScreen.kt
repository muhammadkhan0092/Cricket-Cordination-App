package com.example.fyp.fragments.intro

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fyp.R
import com.example.fyp.activities.MainActivity
import com.example.fyp.databinding.FragmentRegBinding
import com.example.fyp.databinding.FragmentSplashScreenBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentSplashScreen : Fragment() {
    private lateinit var binding : FragmentSplashScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigate()

    }

    private fun navigate() {
        if(FirebaseAuth.getInstance().currentUser!=null){
            val intent = Intent(requireContext(),MainActivity::class.java)
            startActivity(intent)
        }
        else
        {
            CoroutineScope(Dispatchers.IO).launch {
                delay(3000)
                withContext(Dispatchers.Main){
                    findNavController().navigate(R.id.action_fragmentSplashScreen_to_fragmentIntroduction)
                }
            }
        }
    }
}