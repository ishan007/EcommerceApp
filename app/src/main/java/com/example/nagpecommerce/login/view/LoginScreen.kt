package com.example.nagpecommerce.login.view

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nagpecommerce.R
import com.example.nagpecommerce.login.presenter.LoginPresenter
import com.example.nagpecommerce.login.repository.LoginRepository
import com.example.nagpecommerce.product.view.ProductListScreen
import com.example.nagpecommerce.register.view.RegisterScreen
import com.example.nagpecommerce.retrofit.ApiClient
import com.example.nagpecommerce.retrofit.UserApiClient

class LoginScreen : AppCompatActivity(), LoginView{

    private val presenter = LoginPresenter(this, LoginRepository(ApiClient.create(UserApiClient::class.java)))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        init()
    }

    override fun openRegisterScreen() {
        val intent = Intent(application, RegisterScreen::class.java)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    override fun openProductListScreen() {
        val intent = Intent(application, ProductListScreen::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


    private fun init(){
        val emailET = findViewById<EditText>(R.id.email_edit_text)
        val passwordET = findViewById<EditText>(R.id.password_edit_text)
        findViewById<Button>(R.id.login_button).setOnClickListener {
            presenter.login(emailET.text.toString(), passwordET.text.toString())
        }
        findViewById<Button>(R.id.register_button).setOnClickListener {
            presenter.register()
        }
    }
}