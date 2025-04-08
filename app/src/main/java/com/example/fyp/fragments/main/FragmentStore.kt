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
import com.example.fyp.adapters.BrandAdapter
import com.example.fyp.adapters.CricketAdapter
import com.example.fyp.adapters.StoreAdapter
import com.example.fyp.d
import com.example.fyp.data.DataProduct
import com.example.fyp.data.MainData
import com.example.fyp.data.MainData2
import com.example.fyp.data.MainData3
import com.example.fyp.databinding.FragmentHomeBinding
import com.example.fyp.databinding.FragmentRegBinding
import com.example.fyp.databinding.FragmentSplashScreenBinding
import com.example.fyp.databinding.FragmentStoreBinding
import com.example.fyp.databinding.FragmentTournamentBinding
import com.example.fyp.utils.Resource
import com.example.fyp.vm.HomeVm
import com.example.fyp.vm.StoreVm
import com.example.fyp.vmf.HomeVmf
import com.example.fyp.vmf.StoreVmf
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
class FragmentStore : Fragment() {
    private lateinit var StoreAdapter: StoreAdapter
    private lateinit var binding : FragmentStoreBinding
    val viewModel by viewModels<StoreVm> {
        val firestore = FirebaseFirestore.getInstance()
        val firebaseAuth = FirebaseAuth.getInstance()
        StoreVmf(firebaseAuth,firestore)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoreBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRs()
        getData()
        onClickListeners()
        observeProducts()
    }

    private fun observeProducts() {
        lifecycleScope.launch {
            viewModel.getUser.collectLatest {
                when(it){
                    is Resource.Error -> {
                        binding.progressBar6.visibility = View.INVISIBLE
                    }
                    is Resource.Loading -> {
                        binding.progressBar6.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar6.visibility = View.INVISIBLE
                        StoreAdapter.differ.submitList(it.data!!.toList())
                    }
                    is Resource.Unspecified -> {

                    }
                }
            }
        }
    }

    private fun onClickListeners() {
        reebok()
        pumaa()
        adidas()
        nike()
        onProductClick()
    }

    private fun onProductClick() {
        StoreAdapter.onClick = {
            Toast.makeText(requireContext(), "${it.name}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getData() {
        (activity as MainActivity).data.observe(viewLifecycleOwner){
            if(it=="sponsor"){
                viewModel.getProducts()
            }
        }
    }

    private fun reebok() {
        binding.cardView5.setOnClickListener {
            val data = getSpecificCategory(StoreAdapter.differ.currentList,"Reebok")
            if(data==null || data.size==0){
                Toast.makeText(requireContext(), "No Data of this category", Toast.LENGTH_SHORT).show()
            }
            else
            {

            }
        }
    }

    private fun adidas() {
        binding.cardView6.setOnClickListener {
            val data = getSpecificCategory(StoreAdapter.differ.currentList,"Addidas")
            if(data==null || data.size==0){
                Toast.makeText(requireContext(), "No Data of this category", Toast.LENGTH_SHORT).show()
            }
            else
            {

            }
        }
    }

    private fun nike() {
        binding.cardView7.setOnClickListener {
            val data = getSpecificCategory(StoreAdapter.differ.currentList,"Nike")
            if(data==null || data.size==0){
                Toast.makeText(requireContext(), "No Data of this category", Toast.LENGTH_SHORT).show()
            }
            else
            {

            }
        }
    }

    private fun pumaa() {
        binding.cardView8.setOnClickListener {
         val data = getSpecificCategory(StoreAdapter.differ.currentList,"Puma")
            if(data==null || data.size==0){
                Toast.makeText(requireContext(), "No Data of this category", Toast.LENGTH_SHORT).show()
            }
            else
            {

            }
        }
    }

    fun getSpecificCategory(dataProduct: List<DataProduct>, category : String) : List<DataProduct>{
        return dataProduct.filter { it.category ==  category}
    }



    private fun setupRs() {
        StoreAdapter = StoreAdapter()
        binding.recyclerView.adapter = StoreAdapter
        binding.recyclerView.addItemDecoration(d(50))
        //binding.rv.isNestedScrollingEnabled = false
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
    }
}