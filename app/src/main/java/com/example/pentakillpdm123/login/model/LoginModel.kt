package com.example.pentakillpdm123.login.model

// Respuesta de nuestro servicio
data class LoginModel(
    val message: String
)

// Se envia en el body de la peticion
data class LoginDataBody(
    val usrn: String,
    val password: String
)