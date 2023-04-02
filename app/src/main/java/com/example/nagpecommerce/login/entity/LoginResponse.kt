package com.example.nagpecommerce.login.entity

import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName("access_token") val accessToken: String? = null,
                         @SerializedName("refresh_token") val refreshToken: String? = null,
                         @SerializedName("error") val error: String? = null,
                         val isSuccessFull: Boolean = true)
