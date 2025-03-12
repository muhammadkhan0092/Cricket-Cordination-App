package com.example.fyp.fragments.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fyp.R
import com.example.fyp.databinding.FragmentRegBinding
import com.example.fyp.databinding.FragmentRegsponserBinding

class FragmentRegsponser : Fragment() {
    private lateinit var binding :FragmentRegsponserBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegsponserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentIntroduction_to_fragmentRegsponser)
        }
        onGoToLogin()
        onBackButton()
    }

    private fun onBackButton() {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentRegsponser_to_fragmentLoginsponser)
        }
    }

    private fun onGoToLogin() {
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentRegsponser_to_fragmentLoginsponser)
        }
    }
}