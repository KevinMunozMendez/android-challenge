package com.example.notbored.view

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.notbored.common.ActivitiesService
import com.example.notbored.common.entities.ActivityEntity
import com.example.notbored.databinding.ActivitySuggestionBinding
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.function.LongFunction


class SuggestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuggestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuggestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
    }

    private fun setupViewModel() {
        val objectIntent = intent
        val participants = objectIntent.getStringExtra("participants")
        val type = objectIntent.getStringExtra("type")

        val endpoint = "activity?type=$type&participants=$participants"

        lifecycleScope.launch {
            setUi(getContacts(endpoint))
        }
    }

    private suspend fun getContacts(endpoint: String): ActivityEntity = withContext(Dispatchers.IO) {

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: ActivitiesService = retrofit.create(ActivitiesService::class.java)
        service.getContacts(endpoint)
    }

    private fun setUi(activity: ActivityEntity) {

        val price = (activity.price) * 10
        when(price.toInt()) {
            0 -> binding.tvPrice.text = "Free"
            in 1..3 -> binding.tvPrice.text = "Low"
            in 4..6 -> binding.tvPrice.text = "Medium"
            else -> binding.tvPrice.text = "High"

        }

        binding.title.text = activity.activity
        binding.numParticipants.text = activity.participants.toString()
    }

}