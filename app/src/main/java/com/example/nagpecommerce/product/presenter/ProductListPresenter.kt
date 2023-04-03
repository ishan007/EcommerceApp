package com.example.nagpecommerce.product.presenter

import com.example.nagpecommerce.product.entity.Product
import com.example.nagpecommerce.product.repository.ProductListRepository
import com.example.nagpecommerce.product.view.ProductListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductListPresenter(private val view: ProductListView, private val repository: ProductListRepository) {

    fun searchProduct(category: String){
        val productCall = repository.searchProduct(category.trim())
        productCall.enqueue(object : Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        if(it.isEmpty()){
                            view.showToast("Sorry no products in this category!")
                        }else{
                            view.onSearchResponse(it)
                        }
                    }
                }else{
                    view.showToast("Something went wrong")
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                view.showToast(t.message+"")
            }

        })
    }

}