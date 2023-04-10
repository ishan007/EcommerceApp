package com.example.nagpecommerce.login.view

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.nagpecommerce.R
import com.example.nagpecommerce.login.entity.LoginResponse
import com.example.nagpecommerce.login.presenter.LoginPresenter
import com.example.nagpecommerce.login.repository.LoginRepository
import com.example.nagpecommerce.main.MainActivity
import com.example.nagpecommerce.register.view.RegisterScreen
import com.example.nagpecommerce.retrofit.ApiClient
import com.example.nagpecommerce.retrofit.UserApiClient

const val ACCESS_TOKEN = "access_token"
const val REFRESH_TOKEN = "refresh_token"
const val EMAIL = "email"
const val USER_PREF = "user_pref"
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
        val intent = Intent(application, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    override fun saveTokens(loginResponse: LoginResponse) {
        getSharedPreferences(USER_PREF, MODE_PRIVATE).edit {
            putString(ACCESS_TOKEN, loginResponse.accessToken)
            putString(REFRESH_TOKEN, loginResponse.refreshToken)
        }
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


    private fun init(){
        val emailET = findViewById<EditText>(R.id.email_edit_text)
        val passwordET = findViewById<EditText>(R.id.password_edit_text)
        findViewById<Button>(R.id.login_button).setOnClickListener {
            saveEmail(emailET.text.toString())
            presenter.login(emailET.text.toString(), passwordET.text.toString())
        }
        findViewById<Button>(R.id.register_button).setOnClickListener {
            presenter.register()
        }
    }

    private fun saveEmail(email: String){
        getSharedPreferences(USER_PREF, MODE_PRIVATE).edit {
            putString(EMAIL, email)
        }
    }
}