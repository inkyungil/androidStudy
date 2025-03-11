package com.example.wowapplication.service

data class ApiResponse<T>(
    val success: Boolean,
    val data: T?,
    val message: String?
)
