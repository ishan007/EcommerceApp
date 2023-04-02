package com.example.nagpecommerce.product.view

import com.example.nagpecommerce.product.entity.Product

interface ProductListView {

    fun onSearchResponse(products: List<Product>)
    fun showToast(msg: String)

}