package com.example.notbored.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
            val intentToActivities = Intent(this, CategoriesActivity::class.java)
            intentToActivities.putExtra("participants", binding.etParticipants.text.toString())
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

}