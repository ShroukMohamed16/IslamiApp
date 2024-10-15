package com.example.islamiapproute.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.islamiapproute.R
import com.example.islamiapproute.main.hadeth.HadethFragment
import com.example.islamiapproute.main.quran.QuranFragment
import com.example.islamiapproute.main.radio.RadioFragment
import com.example.islamiapproute.main.sebha.SebhaFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView
    lateinit var appBarLayout: AppBarLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottomNavigationView)
        appBarLayout = findViewById(R.id.app_bar)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.quran_item -> {
                    showFragment(QuranFragment())
                }

                R.id.hadeth_item -> {
                    showFragment(HadethFragment())
                }

                R.id.sebha_item -> {
                    showFragment(SebhaFragment())

                }

                R.id.radio_item -> {
                    showFragment(RadioFragment())

                }
            }
            return@setOnItemSelectedListener true
        }

        bottomNav.selectedItemId =R.id.quran_item
    }
     fun hideBars(){
         Log.d("TAG", "hideBars: ")
        bottomNav.visibility = View.GONE
    }

     fun showBars(){
         Log.d("TAG", "showBars: ")
     bottomNav.visibility = View.VISIBLE
    }
    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}