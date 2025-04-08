package com.example.fyp.fragments.main
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fyp.R
import com.example.fyp.adapters.BrandAdapter
import com.example.fyp.adapters.CricketAdapter
import com.example.fyp.adapters.StoreAdapter
import com.example.fyp.d
import com.example.fyp.data.MainData
import com.example.fyp.data.MainData2
import com.example.fyp.data.MainData3
import com.example.fyp.databinding.FragmentHomeBinding
import com.example.fyp.databinding.FragmentRegBinding
import com.example.fyp.databinding.FragmentSplashScreenBinding
import com.example.fyp.databinding.FragmentStoreBinding
import com.example.fyp.databinding.FragmentTournamentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask
class FragmentStore : Fragment() {
    private lateinit var StoreAdapter: StoreAdapter
    private lateinit var binding : FragmentStoreBinding
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
        setupData()
        pumaa()
        nike()
        adidas()
        reebok()
        StoreAdapter.onClick = {
            Toast.makeText(requireContext(), "${it.name}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun reebok() {
        binding.reebok.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentStore_to_fragmentReebokPage)
        }
    }

    private fun adidas() {
        binding.adidas.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentStore_to_fragmentAdidasPage)
        }
    }

    private fun nike() {
        binding.niike.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentStore_to_fragmentNikePage)
        }
    }

    private fun pumaa() {
        binding.puma.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentStore_to_fragmentPumaPage)
        }
    }


    private fun setupData() {
        val list = listOf(
            MainData3(image = R.drawable.shoes, name = "CoverDrive X shoes", Price = "2500 Rps"),
            MainData3(image = R.drawable.s3, name = "Circket Soft Shoes", Price = "4000 Rps"),
            MainData3(image = R.drawable.s2, name = "BatGrip Ultra Shirt", Price = "2500 Rps"),
            MainData3(image = R.drawable.s1, name = "Sixer Sprint Shoes", Price = "2500 Rps"),
            MainData3(image = R.drawable.d4, name = "SpinWizard  Shirt", Price = "5000 Rps"),
            MainData3(image = R.drawable.d5, name = "Yorker  Shirt", Price = "3500 Rps"),
            MainData3(image = R.drawable.s1, name = "BladeRunner  Shoes", Price = "3000 Rps"),
        )
        StoreAdapter.differ.submitList(list)
    }
    private fun setupRs() {
        StoreAdapter = StoreAdapter()
        binding.recyclerView.adapter = StoreAdapter
        binding.recyclerView.addItemDecoration(d(50))
        //binding.rv.isNestedScrollingEnabled = false
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
    }
}