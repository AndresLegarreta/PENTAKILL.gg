package com.example.pentakillpdm123.login.network

import com.example.pentakillpdm123.RetrofitInstance
import com.example.pentakillpdm123.login.model.LoginDataBody
import com.example.pentakillpdm123.login.model.LoginModel

class LoginRepository {
    private val loginService = RetrofitInstance.loginService

    suspend fun doLogin(loginData: LoginDataBody): LoginModel {

        return loginService.doLogin(loginData)
    }
}