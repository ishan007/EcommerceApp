package com.example.nagpecommerce.login.repository

import com.example.nagpecommerce.login.entity.LoginRequest
import com.example.nagpecommerce.login.entity.LoginResponse
import com.example.nagpecommerce.retrofit.LOGIN_PATH
import com.example.nagpecommerce.retrofit.USER_SERVICE_URL
import com.example.nagpecommerce.retrofit.UserApiClient
import retrofit2.Call

class LoginRepository(private val apiClient: UserApiClient) {

    fun login(loginRequest: LoginRequest): Call<LoginResponse>{
        val loginUrl = USER_SERVICE_URL+ LOGIN_PATH
        return apiClient.login(loginUrl, loginRequest)
    }

}