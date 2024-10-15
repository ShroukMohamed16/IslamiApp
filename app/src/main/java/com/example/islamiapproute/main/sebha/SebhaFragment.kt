package com.example.islamiapproute.main.sebha

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.islamiapproute.R
import com.example.islamiapproute.databinding.FragmentSebaBinding

class SebhaFragment : Fragment() {

    lateinit var azkar:List<String>
    var counter = 0
    var currentZekr = 0
    private  var _binding : FragmentSebaBinding? = null
    private val binding get() = _binding!! // get()  solve null pointer exception


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding =  FragmentSebaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkar = resources.getStringArray(R.array.azkar).toList()
        Log.d("TAG", "onViewCreated: ${azkar[currentZekr]}")
        binding.zekr.text = azkar[currentZekr]
        binding.tsbeehCount.text = counter.toString()
        initClick()

    }

    private fun initClick() {
        binding.headSebha.setOnClickListener {
            rotateSebha()
        }
        binding.bodySebha.setOnClickListener {
            rotateSebha()
        }
        binding.zekr.setOnClickListener {
            rotateSebha()
        }
        binding.tsbeehCount.setOnClickListener {
            rotateSebha()
        }
    }

    private fun rotateSebha(){
        binding.bodySebha.rotation += (360 / 33).toFloat()
        if(counter < 33)
            counter++
        else {
            counter = 0
            Log.d("TAG", "rotateSebha: ${azkar.size}")
            currentZekr = if( currentZekr < azkar.size - 1 ) ++currentZekr else 0
            Log.d("TAG", "rotateSebha: $currentZekr")
            binding.zekr.text = azkar[currentZekr]
        }
        binding.tsbeehCount.text = counter.toString()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}