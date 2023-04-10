package com.example.nagpecommerce.profile.repository

import com.example.nagpecommerce.profile.User
import com.example.nagpecommerce.retrofit.GET_USER_PATH
import com.example.nagpecommerce.retrofit.USER_SERVICE_URL
import com.example.nagpecommerce.retrofit.UserApiClient
import retrofit2.Call

class ProfileRepository(private val apiClient: UserApiClient) {

    fun getUser(auth: String): Call<User> {
        val getUserUrl = USER_SERVICE_URL + GET_USER_PATH
        return apiClient.getUser(getUserUrl, "Bearer $auth")
    }

}