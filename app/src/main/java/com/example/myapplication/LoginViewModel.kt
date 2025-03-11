package com.example.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var username = MutableLiveData("")
    var password = MutableLiveData("")

    // 로그인 버튼 클릭 시 처리할 함수
    fun onLoginClick() {
        Log.d("login" , "로그인 버틐 클릭")
        // 로그인 로직
        if (username.value == "user" && password.value == "password") {
            // 로그인 성공
        } else {
            // 로그인 실패
        }
    }
}
