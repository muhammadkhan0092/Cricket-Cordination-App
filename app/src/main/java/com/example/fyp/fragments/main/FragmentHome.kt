package com.example.fyp.fragments.main
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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fyp.R
import com.example.fyp.activities.MainActivity
import com.example.fyp.adapters.CricketAdapter
import com.example.fyp.d
import com.example.fyp.data.DataProduct
import com.example.fyp.data.MainData
import com.example.fyp.databinding.FragmentHomeBinding
import com.example.fyp.databinding.FragmentRegBinding
import com.example.fyp.databinding.FragmentSplashScreenBinding
import com.example.fyp.utils.Resource
import com.example.fyp.vm.HomeVm
import com.example.fyp.vm.SponsorSignUpVm
import com.example.fyp.vmf.HomeVmf
import com.example.fyp.vmf.SponsorSignUpVmf
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask
class FragmentHome : Fragment() {
    private lateinit var cricketAdapter: CricketAdapter
    private lateinit var binding : FragmentHomeBinding
    private var type = ""
    val viewModel by viewModels<HomeVm> {
        val firestore = FirebaseFirestore.getInstance()
        val firebaseAuth = FirebaseAuth.getInstance()
        HomeVmf(firebaseAuth,firestore)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRv()
        setupUsersAdapter()
        observeUsers()
         (activity as MainActivity).data.observe(viewLifecycleOwner){
             type = it
             Log.d("khan","received type in home as $it")
             if(type=="sponsor"){
                 viewModel.getUsers()
                 binding.cardView11.visibility = View.GONE
             }
         }


        cricketAdapter.onClick = {
            Toast.makeText(requireContext(), "${it.name}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupUsersAdapter() {
        cricketAdapter = CricketAdapter()
        binding.rv.adapter = cricketAdapter
        binding.rv.addItemDecoration(d(50))
        // binding.rv.isNestedScrollingEnabled = false
        binding.rv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
    }

    private fun observeUsers() {
        lifecycleScope.launch {
            viewModel.getUser.collectLatest {
                when(it){
                    is Resource.Error -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        binding.progressBar4.visibility = View.INVISIBLE
                    }
                    is Resource.Loading -> {
                        binding.progressBar4.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar4.visibility = View.INVISIBLE
                        if(it.data?.size!=0){
                            cricketAdapter.differ.submitList(it.data!!.toList())
                        }
                        else
                        {

                        }
                    }
                    is Resource.Unspecified -> {

                    }
                }
            }
        }
    }



    private fun setupRv() {
        cricketAdapter = CricketAdapter()
        binding.rv.adapter = cricketAdapter
        binding.rv.addItemDecoration(d(50))
       // binding.rv.isNestedScrollingEnabled = false
        binding.rv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
    }


}