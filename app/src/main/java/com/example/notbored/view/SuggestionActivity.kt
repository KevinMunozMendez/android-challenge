package com.example.notbored.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.notbored.R
import com.example.notbored.databinding.ActivityMainBinding
import com.example.notbored.databinding.ActivitySuggestionBinding
import com.example.notbored.viewModel.MainViewModel

class SuggestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuggestionBinding
    private lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuggestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        mMainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
//
//        mMainViewModel.setSuggestion()
//        mMainViewModel.getSuggestion.observe(this) {
//            Log.i("a verr que pasa", it.toString())
//        }
    }
}