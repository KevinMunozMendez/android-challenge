package com.example.notbored.model

import android.hardware.usb.UsbEndpoint
import android.util.Log
import com.example.notbored.common.ActivitiesService
import com.example.notbored.common.entities.ActivityEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainInteractor {

    suspend fun getContacts(endpoint: String): ActivityEntity = withContext(Dispatchers.IO) {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.boredapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: ActivitiesService = retrofit.create(ActivitiesService::class.java)
        service.getContacts(endpoint)
    }

}