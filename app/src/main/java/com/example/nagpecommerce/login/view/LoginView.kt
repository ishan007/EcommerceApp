package com.example.nagpecommerce.login.view

import com.example.nagpecommerce.login.entity.LoginResponse

interface LoginView {

    fun openRegisterScreen()
    fun openProductListScreen()
    fun saveTokens(loginResponse: LoginResponse)
    fun showToast(msg: String)

}