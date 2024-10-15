package com.example.islamiapproute.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapproute.main.MainActivity
import com.example.islamiapproute.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splach)
        Handler(Looper.getMainLooper()).postDelayed(
            Runnable{
                goToHomeActivity()
            }
            ,2000
        )

    }

    private fun goToHomeActivity() {
        val intent : Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}