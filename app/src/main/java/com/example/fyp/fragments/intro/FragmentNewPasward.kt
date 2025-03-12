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
import com.example.fyp.databinding.FragmentNewpaswadBinding

class FragmentNewPasward : Fragment() {
    private lateinit var binding : FragmentNewpaswadBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewpaswadBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentNewPasward_to_fragmentPasswardChanged)
        }
        onBackButton()
    }
    private fun onBackButton() {
        binding.btnBack.setOnClickListener {
            // findNavController().navigateUp()
            findNavController().navigate(R.id.action_fragmentNewPasward_to_fragmentForgetPage3)
        }
    }
  }
