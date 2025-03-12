package com.example.fyp.fragments.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fyp.R
import com.example.fyp.databinding.FragmentFpageBinding
import com.example.fyp.databinding.FragmentIntroductionBinding

class FragmentForgetPage : Fragment() {
    private lateinit var binding : FragmentFpageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFpageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentForgetPage3_to_fragmentNewPasward)
        }
        onBackButton()
    }
    private fun onBackButton() {
        binding.btnBack.setOnClickListener {
            // findNavController().navigateUp()
            findNavController().navigate(R.id.action_fragmentForgetPage3_to_fragmentLogin)
        }
    }
  }
