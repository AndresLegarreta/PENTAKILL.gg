package com.example.pentakillpdm123.login.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pentakillpdm123.login.model.LoginDataBody
import com.example.pentakillpdm123.login.model.LoginModel
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {
    private val repository = LoginRepository()
    private val _isLoginSuccessful = MutableLiveData<Boolean>()
    val isLoginSuccessful: LiveData<Boolean> = _isLoginSuccessful
    private val _loginResponse = MutableLiveData<LoginModel>()
    val loginResponse: LiveData<LoginModel> = _loginResponse
    private val _loginAttempted = MutableLiveData<Boolean>()
    val loginAttempted: LiveData<Boolean> = _loginAttempted

    fun doLogin(loginData: LoginDataBody) {
        _loginAttempted.value = true
        viewModelScope.launch {
            try {
                val loginResponse = repository.doLogin(loginData)
                _loginResponse.value = loginResponse
                _isLoginSuccessful.value = loginResponse.message == "login OK"
            } catch (e: Exception) {
                // Handle error
                _isLoginSuccessful.value = false
                Log.d("LoginViewModel", "Error: ${e.message}")
            }
        }
    }
}