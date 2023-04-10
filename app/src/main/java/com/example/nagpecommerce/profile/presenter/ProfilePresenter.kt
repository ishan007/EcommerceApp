package com.example.nagpecommerce.profile.presenter

import com.example.nagpecommerce.profile.User
import com.example.nagpecommerce.profile.repository.ProfileRepository
import com.example.nagpecommerce.profile.view.ProfileView
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilePresenter(private val view: ProfileView, private val repository: ProfileRepository) {

    fun getUser(auth: String){
        val userCall = repository.getUser(auth)
        userCall.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful) {
                    view.showUser(response.body() ?: User("", "", ""))
                }else{
                    val errorResponse = Gson().fromJson(response.errorBody()?.string(), JsonObject::class.java)
                    view.showToast(errorResponse.get("error").asString + "")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                view.showToast(t.message+"")
            }

        })
    }
}