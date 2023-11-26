package com.example.pentakillpdm123.login.register

import com.example.pentakillpdm123.login.model.RegisterDataBody
import com.example.pentakillpdm123.login.model.RegisterModel
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("users/registrar")
    suspend fun doRegister(@Body loginData: RegisterDataBody): RegisterModel
}