package com.example.pentakillpdm123.login.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pentakillpdm123.login.model.LoginDataBody
import com.example.pentakillpdm123.login.model.LoginModel
import com.example.pentakillpdm123.login.model.RegisterDataBody
import com.example.pentakillpdm123.login.model.RegisterModel
import com.example.pentakillpdm123.login.network.LoginRepository
import kotlinx.coroutines.launch

class RegisterViewModel() : ViewModel() {
    private val repository = RegisterRepository()
    private val _isRegisterSuccessful = MutableLiveData<Boolean>()
    val isRegisterSuccessful: LiveData<Boolean> = _isRegisterSuccessful
    private val _registerResponse = MutableLiveData<RegisterModel>()
    val registerResponse: LiveData<RegisterModel> = _registerResponse
    private val _registerAttempted = MutableLiveData<Boolean>()
    val registerAttempted: LiveData<Boolean> = _registerAttempted

    fun doRegister(registerData: RegisterDataBody) {
        _registerAttempted.value = true
        viewModelScope.launch {
            try {
                val registerResponse = repository.doRegister(registerData)
                _registerResponse.value = registerResponse
                if (registerResponse.message == "Register OK"){
                    _isRegisterSuccessful.value = true
                }else {
                    _isRegisterSuccessful.value = false
                }
            } catch (e: Exception) {
                // Handle error
                _isRegisterSuccessful.value = false
                Log.d("LoginViewModel", "Error: ${e.message}")
            }
        }
    }
}