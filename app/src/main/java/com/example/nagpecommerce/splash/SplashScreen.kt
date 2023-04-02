package com.example.nagpecommerce.splash

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.nagpecommerce.R
import com.example.nagpecommerce.login.view.LoginScreen
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
                val intent = Intent(application, LoginScreen::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }, 1500)
    }
}