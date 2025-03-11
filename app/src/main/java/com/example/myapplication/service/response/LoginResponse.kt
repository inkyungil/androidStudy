package com.example.wowapplication.service.response

data class LoginResponse(
    val success: Boolean,
    val token: String?,
    val name: String?,
    val tel: String?,
    val email: String?,
    val sname: String?,
    val usertype: String?,
    val message: String?,
    val id: String?,
    val pass: String?
)
