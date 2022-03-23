package com.example.notbored.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.notbored.common.ActivitiesService
import com.example.notbored.common.entities.ActivityEntity
import com.example.notbored.databinding.ActivitySuggestionBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SuggestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuggestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuggestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()

        binding.topAppBar.setNavigationOnClickListener {
            finish()
        }

        binding.btnTryAnother.setOnClickListener {
            setupViewModel()
        }
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
            lifecycleScope.launch {
                setUi(getContacts(endpoint))
            }
        } else {
            binding.topAppBar.title = "Random"
            binding.layoutType.visibility = View.VISIBLE
            lifecycleScope.launch {
                setUi(getContacts(endpoint2))
            }
        }
    }

    private suspend fun getContacts(endpoint: String): ActivityEntity =
        withContext(Dispatchers.IO) {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://www.boredapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service: ActivitiesService = retrofit.create(ActivitiesService::class.java)
            service.getContacts(endpoint)
        }

    private fun setUi(activity: ActivityEntity) {

        val price = (activity.price) * 10
        when (price.toInt()) {
            0 -> binding.tvPrice.text = "Free"
            in 1..3 -> binding.tvPrice.text = "Low"
            in 4..6 -> binding.tvPrice.text = "Medium"
            else -> binding.tvPrice.text = "High"
        }

        binding.title.text = activity.activity
        binding.numParticipants.text = activity.participants.toString()
        binding.tvActivity.text = activity.type.replaceFirstChar { it.uppercase() }
    }
}