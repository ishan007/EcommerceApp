package com.example.nagpecommerce.splash

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.nagpecommerce.R
import com.example.nagpecommerce.login.view.ACCESS_TOKEN
import com.example.nagpecommerce.login.view.LoginScreen
import com.example.nagpecommerce.login.view.USER_PREF
import com.example.nagpecommerce.main.MainActivity
import com.example.nagpecommerce.product.view.ProductListScreen
import kotlinx.coroutines.Runnable

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        navigateToLoginScreen()
    }

    private fun navigateToLoginScreen(){
        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                val intent = if(shouldNavigateToLoginScreen()){
                    Intent(application, LoginScreen::class.java)
                }else{
                    Intent(application, MainActivity::class.java)
                }

                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }, 1500)
    }

    private fun shouldNavigateToLoginScreen(): Boolean{
        val token = getSharedPreferences(USER_PREF, MODE_PRIVATE).getString(ACCESS_TOKEN, null)
        if(token == null || token == ""){
            return true
        }
        return false
    }
}