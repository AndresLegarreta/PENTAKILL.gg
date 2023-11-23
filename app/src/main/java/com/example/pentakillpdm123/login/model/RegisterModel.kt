package com.example.pentakillpdm123.login.model


data class RegisterModel(
    val message: String,
    val obj: UserModel
)

data class UserModel(
    val username: String,
    val password: String,
    val correouser: String,
    val _id: String,
)

// Se envia en el body de la peticion
data class RegisterDataBody(
    val us: String,
    val pass: String,
    val correo: String
)