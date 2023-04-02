package com.example.nagpecommerce.register.repository

import com.example.nagpecommerce.login.entity.LoginResponse
import com.example.nagpecommerce.register.entity.RegisterRequest
import com.example.nagpecommerce.retrofit.REGISTER_PATH
import com.example.nagpecommerce.retrofit.USER_SERVICE_URL
import com.example.nagpecommerce.retrofit.UserApiClient
import retrofit2.Call

class RegisterRepository(private val userApiClient: UserApiClient) {

    fun register(registerRequest: RegisterRequest): Call<LoginResponse>{
        val registerUrl = USER_SERVICE_URL + REGISTER_PATH
        return userApiClient.register(registerUrl, registerRequest)
    }

}