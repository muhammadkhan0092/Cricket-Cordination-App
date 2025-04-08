package com.example.fyp.fragments.intro

import android.content.Intent
import android.os.Bundle
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
import com.bumptech.glide.Glide
import com.example.fyp.R
import com.example.fyp.activities.IntroActivity
import com.example.fyp.activities.MainActivity
import com.example.fyp.data.DataSponsor
import com.example.fyp.databinding.FragmentGigBinding
import com.example.fyp.databinding.FragmentIntroductionBinding
import com.example.fyp.databinding.FragmentLoginBinding
import com.example.fyp.databinding.FragmentSponsorProfileBinding
import com.example.fyp.utils.Resource
import com.example.fyp.vm.HomeVm
import com.example.fyp.vm.ProfileVm
import com.example.fyp.vmf.HomeVmf
import com.example.fyp.vmf.ProfileVmf
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FragmentSponsorProfile : Fragment() {
    private lateinit var binding : FragmentSponsorProfileBinding
    private lateinit var sponsor: DataSponsor
    val viewModel by viewModels<ProfileVm> {
        val firestore = FirebaseFirestore.getInstance()
        val firebaseAuth = FirebaseAuth.getInstance()
        ProfileVmf(firebaseAuth,firestore)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSponsorProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        observeUsers()
        observeLogout()
        onClickListeners()
    }

    private fun onClickListeners() {
        onLogoutClicked()
        onEditClicked()
    }

    private fun onEditClicked() {
        binding.button7.setOnClickListener {
            val bundle = Bundle().also {
                it.putParcelable("sponsor",sponsor)
            }
            findNavController().navigate(R.id.action_fragmentSponsorProfile_to_fragmentSponsorProfileEdit,bundle)
        }
    }

    private fun onLogoutClicked() {
        binding.textView94.setOnClickListener {
            viewModel.logout()
        }
        binding.imageView56.setOnClickListener {
            viewModel.logout()
        }
    }


    private fun observeUsers() {
            lifecycleScope.launch {
                viewModel.getUser.collectLatest {
                    when(it){
                        is Resource.Error -> {
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                            binding.progressBar5.visibility = View.INVISIBLE
                        }
                        is Resource.Loading -> {
                            binding.progressBar5.visibility = View.VISIBLE
                        }
                        is Resource.Success -> {
                            binding.progressBar5.visibility = View.INVISIBLE
                            sponsor = it.data!!
                            setData(it.data!!)
                        }
                        is Resource.Unspecified -> {

                        }
                    }
                }
            }
        }

    private fun observeLogout() {
        lifecycleScope.launch {
            viewModel.logout.collectLatest {
                when(it){
                    is Resource.Error -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        binding.progressBar5.visibility = View.INVISIBLE
                    }
                    is Resource.Loading -> {
                        binding.progressBar5.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar5.visibility = View.INVISIBLE
                        val intent = Intent(requireContext(),IntroActivity::class.java)
                        startActivity(intent)
                        requireActivity().finish()
                    }
                    is Resource.Unspecified -> {

                    }
                }
            }
        }
    }

    private fun setData(data: DataSponsor) {
        if(!data.image.isNullOrEmpty()){
            Glide.with(requireContext()).load(data.image).into(binding.imageView55)
        }
        binding.textView92.text = data.name
        binding.textView93.text = data.email
    }


    private fun getData() {
        (activity as MainActivity).data.observe(viewLifecycleOwner){
            Log.d("khan","received type in profile as $it")
            if(it=="sponsor"){
                (activity as MainActivity).binding.bnvSponsor.visibility =  View.VISIBLE
                viewModel.getUser(FirebaseAuth.getInstance().uid.toString())
            }
        }
    }

}