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
import com.example.fyp.databinding.FragmentIntroductionBinding
import com.example.fyp.databinding.FragmentLoginBinding
import com.example.fyp.databinding.FragmentRegGround1Binding
import com.example.fyp.databinding.FragmentRegGroundBinding

class FragmentRGround : Fragment() {
    private lateinit var binding : FragmentRegGround1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegGround1Binding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
