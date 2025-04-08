package com.example.fyp.fragments.intro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fyp.R
import com.example.fyp.activities.MainActivity
import com.example.fyp.data.DataSponsor
import com.example.fyp.databinding.FragmentRegsponserBinding
import com.example.fyp.utils.Resource
import com.example.fyp.vm.SponsorSignUpVm
import com.example.fyp.vmf.SponsorSignUpVmf
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FragmentRegsponser : Fragment() {
    private lateinit var binding :FragmentRegsponserBinding
    private val navArgs by navArgs<FragmentRegsponserArgs>()
    val viewModel by viewModels<SponsorSignUpVm> {
        val firestore = FirebaseFirestore.getInstance()
        val firebaseAuth = FirebaseAuth.getInstance()
        SponsorSignUpVmf(firebaseAuth,firestore)
    }
    private var type : String = ""
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
        setType()
        onClickListeners()
        obsevreUser()
    }

    private fun setType() {
        type = navArgs.type
    }

    private fun onClickListeners() {
        onGoToLogin()
        onRegistrationClicked()
        onBackButton()
    }

    private fun onBackButton() {
        binding.btnBack.setOnClickListener {
            val bundle = Bundle().also {
                it.putString("type",type)
            }
            findNavController().navigate(R.id.action_fragmentRegsponser_to_fragmentLoginsponser,bundle)
        }
    }

    private fun onGoToLogin() {
        binding.tvGoToLogin.setOnClickListener {
            val bundle = Bundle().also {
                it.putString("type",type)
            }
            findNavController().navigate(R.id.action_fragmentRegsponser_to_fragmentLoginsponser,bundle)
        }
    }

    private fun obsevreUser() {
        lifecycleScope.launch {
            viewModel.createUser.collectLatest {
                when(it){
                    is Resource.Error -> {
                        binding.progressBar2.visibility = View.INVISIBLE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Loading ->{
                        binding.progressBar2.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar2.visibility = View.INVISIBLE
                        Toast.makeText(requireContext(), "Registration Successfull", Toast.LENGTH_SHORT).show()
                        val intent = Intent(requireContext(), MainActivity::class.java)
                        intent.putExtra("type",type)
                        Log.d("khan","sending type from reg ${type}")
                        startActivity(intent)
                        requireActivity().finish()
                    }
                    is Resource.Unspecified -> {

                    }
                }
            }
        }
    }

    private fun onRegistrationClicked() {
        binding.btnLogin.setOnClickListener {
            val fullName = binding.textView10.text.toString()
            val email = binding.editTextTextEmailAddress2.text.toString()
            val companyName = binding.textView84.text.toString()
            val designation = binding.textView85.text.toString()
            val pass =binding.editTextTextPassword.text.toString()
            val confirmPass = binding.editText.text.toString()
             if(fullName.isNullOrEmpty() || email.isNullOrEmpty() || companyName.isNullOrEmpty() ||designation.isNullOrEmpty() || pass.isNullOrEmpty() || confirmPass.isNullOrEmpty()){
            Toast.makeText(requireContext(), "fill all the details", Toast.LENGTH_SHORT).show()
             }
            else if(pass!=confirmPass){
                Toast.makeText(requireContext(), "passwords do not match", Toast.LENGTH_SHORT).show()
            }
            else if(pass.length<8){
                Toast.makeText(requireContext(), "password should be minimum 8 charcters", Toast.LENGTH_SHORT).show()
            }
            else{
                val sponsor = DataSponsor("",email,pass,companyName,designation,fullName)
                viewModel.createSponsorWithEmailAndPass(sponsor)
            }
        }
    }
}