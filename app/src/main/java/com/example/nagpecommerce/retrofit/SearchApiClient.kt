package com.example.nagpecommerce.retrofit

import com.example.nagpecommerce.product.entity.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.Url

interface SearchApiClient {

    @Headers("Content-Type: application/json")
    @GET
    fun search(@Url url: String, @Query("category") category: String): Call<List<Product>>

}