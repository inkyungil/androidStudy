package com.example.wowapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wowapplication.util.ConsumableValue
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {
    sealed class Action {
        data class SERVICE_FAIL(val errorMessage: String) : Action()
    }

    private val _serviceError: MutableLiveData<ConsumableValue<Action>> = MutableLiveData()
    val serviceError: LiveData<ConsumableValue<Action>> get() = _serviceError

    fun <T> executeApiCall(
        apiCall: suspend () -> T,  // suspend 함수 실행
        onSuccess: (T) -> Unit,  // 성공 시 실행할 함수
        onFailure: (String) -> Unit // 실패 시 실행할 함수
    ) {
        viewModelScope.launch {
            try {
                val response = apiCall() // API 실행
                onSuccess(response)
            } catch (exception: Exception) {
                onFailure(exception.message ?: "서비스 실패")
            }
        }
    }

    fun onServiceFail(errorMessage: String) {
        _serviceError.value = ConsumableValue(Action.SERVICE_FAIL(errorMessage))
    }
}
