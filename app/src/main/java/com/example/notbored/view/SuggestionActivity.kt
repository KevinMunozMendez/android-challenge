package com.example.notbored.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.notbored.R
import com.example.notbored.common.ActivitiesService
import com.example.notbored.common.entities.ActivityEntity
import com.example.notbored.databinding.ActivitySuggestionBinding
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.Exception


class SuggestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuggestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuggestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            finish()
        }

        binding.btnTryAnother.setOnClickListener {
            setupViewModel()
        }

        setupViewModel()
    }

    private fun setupViewModel() {
        val objectIntent = intent
        val participants = objectIntent.getStringExtra("participants")
        val type = objectIntent.getStringExtra("type")

        val endpoint = "activity?type=$type&participants=$participants"
        val endpoint2 = "activity?participants=$participants"

        if (!type.isNullOrBlank()) {
            binding.topAppBar.title = type.replaceFirstChar { it.uppercase() }
            binding.layoutType.visibility = View.GONE
            activityResult(endpoint)
        } else {
            binding.topAppBar.title = "Random"
            binding.layoutType.visibility = View.VISIBLE
            activityResult(endpoint2)
        }
    }

    fun activityResult(endpoint: String) {
        lifecycleScope.launch {
            try {
                setUi(getContacts(endpoint))
            } catch (e: Exception) {
                e.printStackTrace()
                error()
            }
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

        binding.progressBar.visibility = View.GONE
        binding.clParticipants.visibility = View.VISIBLE
        binding.clPrice.visibility = View.VISIBLE

        val price = (activity.price) * 10

        when(price.toInt()) {
            0 -> binding.tvPrice.text = getString(R.string.Free)
            in 1..3 -> binding.tvPrice.text = getString(R.string.Low)
            in 4..6 -> binding.tvPrice.text = getString(R.string.Medium)
            else -> binding.tvPrice.text = getString(R.string.High)

        }

        binding.title.text = activity.activity
        binding.numParticipants.text = activity.participants.toString()

        binding.tvActivity.text = activity.type.replaceFirstChar {
            it.uppercase()
        }
    }

    private fun error() {
        binding.title.text = getString(R.string.errorActivity)
        binding.title.setTextColor(Color.RED)
        binding.clParticipants.visibility = View.GONE
        binding.clPrice.visibility = View.GONE
    }
}