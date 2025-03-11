package com.example.wowapplication.service

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiServiceImage {
    @GET
    fun downloadImage(@Url url: String): Call<ResponseBody>
}
