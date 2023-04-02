package com.example.nagpecommerce.register.entity

data class RegisterRequest(val username: String,
                           val firstName: String,
                           val lastName: String,
                           val email: String,
                           val enabled: Boolean = true,
                           val credentials: List<Credentials>)
data class Credentials(val algorithm: String = "custom",
                       val type: String = "password",
                       val temporary: Boolean = false,
                       val value: String)
