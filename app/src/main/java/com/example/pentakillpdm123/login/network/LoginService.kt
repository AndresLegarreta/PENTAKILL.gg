package com.example.pentakillpdm123.login.network

import com.example.pentakillpdm123.login.model.LoginDataBody
import com.example.pentakillpdm123.login.model.LoginModel
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("users/login")
    suspend fun doLogin(@Body loginData: LoginDataBody): LoginModel
}