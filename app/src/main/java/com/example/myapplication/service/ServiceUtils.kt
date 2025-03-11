package com.example.wowapplication.service

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.HttpException

object ServiceUtils {
    // 공통으로 API 응답을 처리하는 함수
    suspend fun <T> fetchApi(call: () -> Call<T>): T {
        return withContext(Dispatchers.IO) {
            try {
                val response = call().execute() // 동기 호출
                if (response.isSuccessful) {
                    Log.v("ifeelbluu", "fetchApi :: ${response.body()}")
                    response.body() ?: throw Exception("빈 응답")
                } else {
                    throw HttpException(response)
                }
            } catch (e: Exception) {
                throw Exception("API 요청 실패: ${e.localizedMessage}")
            }
        }
    }
}
