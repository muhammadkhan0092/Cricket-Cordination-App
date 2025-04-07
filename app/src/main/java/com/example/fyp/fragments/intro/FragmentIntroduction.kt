package com.example.fyp.fragments.intro

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fyp.R
import com.example.fyp.databinding.FragmentIntroductionBinding

class FragmentIntroduction : Fragment() {
    private lateinit var binding : FragmentIntroductionBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroductionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("khan","in introduction")
        onGetStartedListener()
        onGoToLogin()
        onGoTosponser()


    }

    private fun onGoToLogin() {
        binding.btnGoToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentIntroduction_to_fragmentLogin)
        }
    }

    private fun onGoTosponser() {
        binding.btnsponser.setOnClickListener {
            val bundle = Bundle().also {
                it.putString("type","sponsor")
            }
            Log.d("khan","sending sponsor from intro")
            findNavController().navigate(R.id.action_fragmentIntroduction_to_fragmentReg,bundle)
        }
    }
    private fun onGetStartedListener() {
        binding.btnGetStarted.setOnClickListener {
            val bundle = Bundle().also {
                it.putString("type","player")
            }
            Log.d("khan","sending player from intro")
            findNavController().navigate(R.id.action_fragmentIntroduction_to_fragmentReg,bundle)
        }
    }
}