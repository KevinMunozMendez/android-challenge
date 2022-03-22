package com.example.notbored.common

import com.example.notbored.common.entities.ActivityEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface ActivitiesService {
    @GET
    suspend fun getContacts(@Url type: String): ActivityEntity
}