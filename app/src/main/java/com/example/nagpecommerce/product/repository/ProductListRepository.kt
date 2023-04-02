package com.example.nagpecommerce.product.repository

import com.example.nagpecommerce.product.entity.Product
import com.example.nagpecommerce.retrofit.SEARCH_SERVICE_URL
import com.example.nagpecommerce.retrofit.SearchApiClient
import retrofit2.Call

class ProductListRepository(private val searchApiClient: SearchApiClient) {

    fun searchProduct(category: String): Call<List<Product>> {
        return searchApiClient.search(SEARCH_SERVICE_URL, category)
    }

}