package com.example.notbored.common.entities

data class ActivityEntity (
    var activity: String,
    var type: String,
    var participants: Int,
    var price: Float,
    var key: String,
    var accessibility: Float
)