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
import com.example.fyp.d
import com.example.fyp.data.MainData
import com.example.fyp.data.MainData2
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
    private lateinit var brandAdapter: BrandAdapter
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
        brandAdapter.onClick = {
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
            MainData2(1,R.drawable.img11,"2.5 km away","Crystal Park Ground","20,000 Pkr","2.0" ),
            MainData2(2,R.drawable.img_5,"4 km away","Golden Turf Stadium","30,000 Pkr","3.5"),
            MainData2(3,R.drawable.img6,"3.5 km away","Summit View Ground","40,000 Pkr","4.0"),
            MainData2(4,R.drawable.img7,"1.5 km away","Lakeside Ground","45,000 Pkr","5.0"),
            MainData2(5,R.drawable.img8,"1 km away","Bayview Ground","35,000 Pkr","4.5"),
            MainData2(6,R.drawable.img9,"2 km away","Iqbal Ground","25,000 Pkr","3.0"),
            MainData2(7,R.drawable.img10,"3 km away","Bolan Ground","10,000 Pkr","1.5"),
        )
        brandAdapter.differ.submitList(list)
    }
    private fun setupRs() {
        brandAdapter = BrandAdapter()
        binding.recyclerView.adapter = brandAdapter
        binding.recyclerView.addItemDecoration(d(50))
        // binding.rv.isNestedScrollingEnabled = false
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
    }
}