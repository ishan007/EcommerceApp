package com.example.nagpecommerce.profile.view

import com.example.nagpecommerce.profile.User

interface ProfileView {
    fun showUser(user: User)
    fun showToast(msg: String)
}