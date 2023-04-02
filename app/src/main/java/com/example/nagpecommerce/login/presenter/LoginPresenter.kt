package com.example.nagpecommerce.login.presenter

import com.example.nagpecommerce.login.entity.LoginRequest
import com.example.nagpecommerce.login.entity.LoginResponse
import com.example.nagpecommerce.login.repository.LoginRepository
import com.example.nagpecommerce.login.view.LoginView
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(private val view: LoginView, private val repository: LoginRepository) {

    fun login(email: String, password: String){
        val loginCall = repository.login(LoginRequest(email, password))
        loginCall.enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if(response.isSuccessful) {
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


    fun register(){
        view.openRegisterScreen()
    }
}