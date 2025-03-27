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
import com.example.fyp.data.User
import com.example.fyp.databinding.FragmentRegBinding
import com.example.fyp.utils.Resource
import com.example.fyp.vm.SignUpViewModel
import com.example.fyp.vmf.SignUpFactory
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FragmentReg : Fragment() {
    private lateinit var binding : FragmentRegBinding
    private var type : String = ""
    private val navArgs by navArgs<FragmentRegArgs>()
    val viewModel by viewModels<SignUpViewModel> {
        val firestore = FirebaseFirestore.getInstance()
        val firebaseAuth = FirebaseAuth.getInstance()
        SignUpFactory(firebaseAuth,firestore)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onRegistrationClicked()
        getData()
        onGoToLogin()
        onBackButton()
        obsevreUser()
    }

    private fun getData() {
        type = navArgs.type
        Log.d("khan","got type in reg ${type}")
    }


    private fun obsevreUser() {
        lifecycleScope.launch {
            viewModel.createUser.collectLatest {
                when(it){
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.INVISIBLE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Loading ->{
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.INVISIBLE
                        Toast.makeText(requireContext(), "Registration Successfull", Toast.LENGTH_SHORT).show()
                        val intent = Intent(requireContext(),MainActivity::class.java)
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
            val phoneNo = binding.editTextNumber.text.toString()
            val cnic = binding.editTextNumber2.text.toString()
            val pass =binding.editTextTextPassword.text.toString()
            val confirmPass = binding.editText.text.toString()
            if(pass!=confirmPass){
                Toast.makeText(requireContext(), "passwords do not match", Toast.LENGTH_SHORT).show()
            }
            else if(pass.length<8){
                Toast.makeText(requireContext(), "password should be minimum 8 charcters", Toast.LENGTH_SHORT).show()
            }
            else if(fullName.isNullOrEmpty() || email.isNullOrEmpty() || phoneNo.isNullOrEmpty() ||cnic.isNullOrEmpty()){
                Toast.makeText(requireContext(), "fill all the details", Toast.LENGTH_SHORT).show()
            }
            else{
                val user = User("",fullName,phoneNo,cnic,email,pass)
                viewModel.createUserWithEmaiLAndPass(user)
            }
        }
    }

    private fun onBackButton() {
        binding.btnBack.setOnClickListener {
           // findNavController().navigateUp()
            findNavController().navigate(R.id.action_fragmentReg_to_fragmentLogin)
        }
    }

    private fun onGoToLogin() {
        binding.tvGoToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentReg_to_fragmentLogin)
        }
    }
}