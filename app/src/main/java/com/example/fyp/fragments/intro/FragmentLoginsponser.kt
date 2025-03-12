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
import com.example.fyp.databinding.FragmentLoginsponserBinding

class FragmentLoginsponser : Fragment() {
    private lateinit var binding : FragmentLoginsponserBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginsponserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onGoToRegister()
        onBackButton()
        onLoginClick()
        onForgetbutton()
    }

    private fun onForgetbutton() {
        binding.Fbuton.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLoginsponser_to_fragmentForgetPage3)
        }

    }

    private fun onLoginClick() {
        binding.btnLogin.setOnClickListener {
            val intent = Intent(requireContext(),MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun onBackButton() {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentIntroduction)
        }
    }

    private fun onGoToRegister() {
        binding.tvGoToRegister.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentReg)
        }
    }
}