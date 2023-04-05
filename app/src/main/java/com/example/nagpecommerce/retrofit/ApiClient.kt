package com.example.nagpecommerce.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val USER_SERVICE_URL = "http://40.76.169.194:8081"
const val SEARCH_SERVICE_URL = "http://40.76.169.194:8082/search/products"
const val LOGIN_PATH = "/user/login"
const val REGISTER_PATH = "/user/register"
object ApiClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://test.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }

}