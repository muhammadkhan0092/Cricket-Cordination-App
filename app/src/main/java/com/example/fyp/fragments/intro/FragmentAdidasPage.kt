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
import com.example.fyp.databinding.FragmentAdidaspageBinding
import com.example.fyp.databinding.FragmentIntroductionBinding
import com.example.fyp.databinding.FragmentLoginBinding
import com.example.fyp.databinding.FragmentNikepageBinding
import com.example.fyp.databinding.FragmentPumapageBinding

class FragmentAdidasPage : Fragment() {
    private lateinit var binding: FragmentAdidaspageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdidaspageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Shoes()
        Pads()
        Shirt()
    }

    private fun Shirt() {
        binding.cardView16.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentAdidasPage_to_fragmentGigPage9)
        }
    }

    private fun Pads() {
        binding.cardView12.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentAdidasPage_to_fragmentGigPage8)
        }
    }

    private fun Shoes() {
        binding.cardView15.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentAdidasPage_to_fragmentGigPage7)
        }
    }
}