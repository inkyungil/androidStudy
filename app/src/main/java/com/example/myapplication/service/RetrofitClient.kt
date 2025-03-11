package com.example.wowapplication.service

import com.example.wowapplication.common.Property
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // 로그를 찍기 위한 LoggingInterceptor
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY  // 요청과 응답 본문을 모두 로그로 찍음
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)  // OkHttpClient에 LoggingInterceptor 추가
        .build()

    val instance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Property.BaseURL)
            .client(client)  // Retrofit에 OkHttpClient 설정
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}


