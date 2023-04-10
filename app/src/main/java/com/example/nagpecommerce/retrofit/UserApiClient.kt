package com.example.nagpecommerce.retrofit

import com.example.nagpecommerce.login.entity.LoginRequest
import com.example.nagpecommerce.login.entity.LoginResponse
import com.example.nagpecommerce.profile.User
import com.example.nagpecommerce.register.entity.RegisterRequest
import retrofit2.Call
import retrofit2.http.*

interface UserApiClient {

    @Headers("Content-Type: application/json")
    @POST
    fun login(@Url url: String, @Body loginRequest: LoginRequest): Call<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST
    fun register(@Url url: String, @Body registerRequest: RegisterRequest): Call<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST
    fun getUser(@Url url: String, @Header("Authorization") auth: String): Call<User>
}