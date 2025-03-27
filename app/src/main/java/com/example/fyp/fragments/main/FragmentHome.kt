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
import com.example.fyp.adapters.CricketAdapter
import com.example.fyp.d
import com.example.fyp.data.MainData
import com.example.fyp.databinding.FragmentHomeBinding
import com.example.fyp.databinding.FragmentRegBinding
import com.example.fyp.databinding.FragmentSplashScreenBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask
class FragmentHome : Fragment() {
    private lateinit var cricketAdapter: CricketAdapter
    private lateinit var binding : FragmentHomeBinding
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
        setupData()

        cricketAdapter.onClick = {
            Toast.makeText(requireContext(), "${it.name}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun zaryab() {
        Toast.makeText(requireContext(), "geeg", Toast.LENGTH_SHORT).show()
    }

    private fun setupData() {
        val list = listOf(
            MainData(age = 25, image =R.drawable.babar, name = "Babar Azam", rating = "4.5" , category = "Batsmen"),
            MainData(age = 26, image =R.drawable.babar, name = "Zaryab Ali Haider", rating = "5.0" , category = "Bowler"),
            MainData(age = 27, image =R.drawable.babar, name = "Muhammad Khan", rating = "4.1" , category = "Batsmen"),
            MainData(age = 28, image =R.drawable.babar, name = "Hammad ALi", rating = "4.0" , category = "Batsmen"),
            MainData(age = 29, image =R.drawable.babar, name = "Muhammad Hamza", rating = "4.3" , category = "Bowler"),
            MainData(age = 22, image =R.drawable.babar, name = "Moeed Kayani", rating = "4.8" , category = "Batsmen"),
            MainData(age = 23, image =R.drawable.babar, name = "Hassan Ali", rating = "4.9" , category = "Bowler"),

        )
        cricketAdapter.differ.submitList(list)
    }
    private fun setupRv() {
        cricketAdapter = CricketAdapter()
        binding.rv.adapter = cricketAdapter
        binding.rv.addItemDecoration(d(50))
       // binding.rv.isNestedScrollingEnabled = false
        binding.rv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
    }
}