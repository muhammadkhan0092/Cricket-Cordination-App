package com.example.fyp.fragments.intro

import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.fyp.R
import com.example.fyp.activities.MainActivity
import com.example.fyp.data.DataSponsor
import com.example.fyp.databinding.FragmentGigBinding
import com.example.fyp.databinding.FragmentIntroductionBinding
import com.example.fyp.databinding.FragmentLoginBinding
import com.example.fyp.databinding.FragmentSponsorProfileeditBinding
import com.example.fyp.utils.Resource
import com.example.fyp.vm.EditProfileVm
import com.example.fyp.vm.ProfileVm
import com.example.fyp.vmf.EditProfileVmf
import com.example.fyp.vmf.ProfileVmf
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FragmentSponsorProfileEdit : Fragment() {
    private lateinit var binding : FragmentSponsorProfileeditBinding
    private var uri : Uri? = null
    private var realPath : String? = null
    private val navArgs by navArgs<FragmentSponsorProfileEditArgs>()
    private lateinit var sponsor : DataSponsor
    val viewModel by viewModels<EditProfileVm> {
        val firestore = FirebaseFirestore.getInstance()
        val firebaseAuth = FirebaseAuth.getInstance()
        EditProfileVmf(firebaseAuth,firestore)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSponsorProfileeditBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        sponsor = navArgs.sponsor
        if(!sponsor.image.isNullOrEmpty()){
            Glide.with(requireContext()).load(sponsor.image).into(binding.imageView55)
        }
        binding.textView11.text = Editable.Factory.getInstance().newEditable(sponsor.name)
        binding.textView12.text = Editable.Factory.getInstance().newEditable(sponsor.companyName)
        binding.textView13.text = Editable.Factory.getInstance().newEditable(sponsor.designation)
        onClickListeners()
    }

    private fun onClickListeners() {
        onProfilePicClicked()
        onButtonClicked()
        observeUpdate()
    }

    private fun observeUpdate() {
        lifecycleScope.launch {
            viewModel.update.collectLatest {
                when(it){
                    is Resource.Error -> {
                        binding.progressBar7.visibility = View.INVISIBLE
                    }
                    is Resource.Loading -> {
                        binding.progressBar7.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar7.visibility = View.INVISIBLE
                    }
                    is Resource.Unspecified -> {

                    }
                }
            }
        }
    }

    private fun onButtonClicked() {
        binding.button7.setOnClickListener {
            val name = binding.textView11.text.toString()
            val company = binding.textView12.text.toString()
            val designation = binding.textView13.text.toString()
            if(realPath==null){
                if(name==sponsor.name && company==sponsor.companyName && designation==sponsor.designation){
                    Toast.makeText(requireContext(), "Update the fields", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    val data = sponsor.copy(name = name, companyName = company, designation = designation)
                    viewModel.update(data)
                }
            }
            else
            {
                viewModel.uploadToCloudinary(
                    realPath!!,
                    {
                        val data = sponsor.copy(name = name, companyName = company, designation = designation, image = it)
                        viewModel.update(data)
                    },
                    {
                        Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }

    private fun onProfilePicClicked() {
        binding.imageView55.setOnClickListener {
            val intent  = Intent(ACTION_GET_CONTENT)
            intent.type = "image/*"
            pickProfileImage.launch(intent)
        }
    }

    val pickProfileImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val intent = it.data
        val imageUri = intent?.data
        if(imageUri==null){

        }
        else
        {
            uri = imageUri
            realPath = viewModel.getRealPathFromUri(uri,requireActivity())
            Glide.with(requireContext()).load(uri).into(binding.imageView55)
        }

    }


}