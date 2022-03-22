package com.example.notbored.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.notbored.databinding.ActivityMainBinding
import com.example.notbored.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvTermsAndConditions.setOnClickListener {
            val intentToTermsAndConditions = Intent(this, TermsAndConditionsActivity::class.java)
            startActivity(intentToTermsAndConditions)
        }

        binding.btnStart.setOnClickListener {
            setupViewModel(binding.etParticipants.text.toString())
            val intentToActivities = Intent(this, CategoriesActivity::class.java)
            startActivity(intentToActivities)
        }

        binding.etParticipants.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.btnStart.isEnabled = !(p0.isNullOrBlank() || p0.toString().toInt() <= 0)
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun setupViewModel(participants: String) {
        mMainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mMainViewModel.setParticipants(participants)
    }

}