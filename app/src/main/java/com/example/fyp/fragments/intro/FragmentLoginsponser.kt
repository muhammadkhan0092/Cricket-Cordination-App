package com.example.fyp.fragments.intro

import android.content.Intent
import android.os.Bundle
import android.support.v4.os.IResultReceiver._Parcel
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fyp.R
import com.example.fyp.activities.MainActivity
import com.example.fyp.databinding.FragmentIntroductionBinding
import com.example.fyp.databinding.FragmentLoginBinding
import com.example.fyp.databinding.FragmentLoginsponserBinding
import com.example.fyp.utils.Resource
import com.example.fyp.vm.SponsorLoginVm
import com.example.fyp.vm.SponsorSignUpVm
import com.example.fyp.vmf.SponsorLoginVmf
import com.example.fyp.vmf.SponsorSignUpVmf
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FragmentLoginsponser : Fragment() {
    private lateinit var binding : FragmentLoginsponserBinding
    private val navArgs by navArgs<FragmentLoginsponserArgs>()
    val viewModel by viewModels<SponsorLoginVm> {
        val firestore = FirebaseFirestore.getInstance()
        val firebaseAuth = FirebaseAuth.getInstance()
        SponsorLoginVmf(firebaseAuth,firestore)
    }
    private var type : String ? =null
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
        setType()
        onGoToRegister()
        onBackButton()
        onLoginClick()
        onForgetbutton()
        obsevreUser()
    }

    private fun setType() {
        type = navArgs.type
    }

    private fun onForgetbutton() {
        binding.Fbuton.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLoginsponser_to_fragmentForgetPage3)
        }

    }

    private fun onLoginClick() {
        binding.btnLogin.setOnClickListener {
            Log.d("khan","in sponsor login")
           val email = binding.editTextTextEmailAddress2.text.toString()
            val pass = binding.editTextTextPassword.text.toString()
            if(email.isNullOrEmpty() || pass.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Fill the fields", Toast.LENGTH_SHORT).show()
            }
            else if(pass.length<8){
                Toast.makeText(requireContext(), "passwords must be 8 caracters", Toast.LENGTH_SHORT).show()
            }
            else
            {
                viewModel.getUser(email,pass)
            }
        }
    }
    private fun onBackButton() {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentIntroduction)
        }
    }

    private fun onGoToRegister() {
        binding.tvGoToRegister.setOnClickListener {
            val bundle = Bundle().also {
                it.putString("type",type)
            }
            findNavController().navigate(R.id.action_fragmentIntroduction_to_fragmentRegsponser,bundle)
        }
    }

    private fun obsevreUser() {
        lifecycleScope.launch {
            viewModel.getUser.collectLatest {
                when(it){
                    is Resource.Error -> {
                        binding.progressBar3.visibility = View.INVISIBLE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Loading ->{
                        binding.progressBar3.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar3.visibility = View.INVISIBLE
                        Toast.makeText(requireContext(), "Login Successfull", Toast.LENGTH_SHORT).show()
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
}