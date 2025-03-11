package com.example.wowapplication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    private var isBackPressAvailable = false
    private var backPressedTime: Long = 0

    override fun onResume() {
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //에러 메세지 토스트
    fun showMessageToast(message: String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT ).show()
    }

    fun setBackPressedUse(value:Boolean){
        isBackPressAvailable = value
    }

    override fun onBackPressed() {
        if(isBackPressAvailable){
            if (System.currentTimeMillis() - backPressedTime < 2000) {
                super.onBackPressed()
                finish() // 2초 안에 두 번 누르면 종료
            } else {
                showMessageToast("한 번 더 누르면 종료됩니다.")
                backPressedTime = System.currentTimeMillis()
            }
        }else{
            super.onBackPressed()
        }
    }
}
