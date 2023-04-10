package com.example.nagpecommerce.register.view

import com.example.nagpecommerce.login.entity.LoginResponse

interface RegisterView {

    fun openProductListScreen()
    fun showToast(msg: String)
    fun saveTokens(loginResponse: LoginResponse)
}