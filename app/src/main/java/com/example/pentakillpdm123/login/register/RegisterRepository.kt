package com.example.pentakillpdm123.login.register

import com.example.pentakillpdm123.RetrofitInstance
import com.example.pentakillpdm123.login.model.RegisterDataBody
import com.example.pentakillpdm123.login.model.RegisterModel

class RegisterRepository {
    private val registerService = RetrofitInstance.registerService

    suspend fun doRegister(registerData: RegisterDataBody): RegisterModel {

        return registerService.doRegister(registerData)
    }
}