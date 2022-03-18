package com.example.notbored.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notbored.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTermsAndConditions.setOnClickListener {
            val intentToTermsAndConditions = Intent(this, TermsAndConditionsActivity::class.java)
            startActivity(intentToTermsAndConditions)
        }

        binding.btnStart.setOnClickListener {

        }
    }
}