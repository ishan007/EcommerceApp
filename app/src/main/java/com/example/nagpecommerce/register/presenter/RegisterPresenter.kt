package com.example.nagpecommerce.register.presenter

import com.example.nagpecommerce.login.entity.LoginResponse
import com.example.nagpecommerce.register.entity.RegisterRequest
import com.example.nagpecommerce.register.repository.RegisterRepository
import com.example.nagpecommerce.register.view.RegisterView
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(private val view: RegisterView, private val repository: RegisterRepository) {

    fun onRegisterClick(registerRequest: RegisterRequest){
        val registerCall = repository.register(registerRequest)
        registerCall.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if(response.isSuccessful) {
                    view.saveTokens(response.body() ?: LoginResponse("", ""))
                    view.openProductListScreen()
                }else{
                    val errorResponse = Gson().fromJson(response.errorBody()?.string(), JsonObject::class.java)
                    view.showToast(errorResponse.get("error").asString + "")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view.showToast(t.message+"")
            }

        })
    }
}