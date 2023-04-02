package com.example.nagpecommerce.register.view

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nagpecommerce.R
import com.example.nagpecommerce.product.view.ProductListScreen
import com.example.nagpecommerce.register.entity.Credentials
import com.example.nagpecommerce.register.entity.RegisterRequest
import com.example.nagpecommerce.register.presenter.RegisterPresenter
import com.example.nagpecommerce.register.repository.RegisterRepository
import com.example.nagpecommerce.retrofit.ApiClient
import com.example.nagpecommerce.retrofit.UserApiClient

class RegisterScreen : AppCompatActivity(), RegisterView {

    private val presenter = RegisterPresenter(this, RegisterRepository(ApiClient.create(UserApiClient::class.java)))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)
        init()
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
        val emailEditText = findViewById<EditText>(R.id.email_edit_text)
        val firstNameEditText = findViewById<EditText>(R.id.first_name_edit_text)
        val lastNameEditText = findViewById<EditText>(R.id.last_name_edit_text)
        val passwordEditText = findViewById<EditText>(R.id.password_edit_text)
        findViewById<Button>(R.id.register_button).setOnClickListener {
            onRegisterClick(
                emailEditText.text.toString(),
                firstNameEditText.text.toString(),
                lastNameEditText.text.toString(),
                passwordEditText.text.toString())
        }
    }

    private fun onRegisterClick(email: String?, firstName: String?, lastName: String?, password: String? ){
        val registerRequest = RegisterRequest(
            username = email+"",
            firstName = firstName+"",
            lastName = lastName+"",email=email+"",
            credentials = listOf(Credentials(value = password+""))
        )
        presenter.onRegisterClick(registerRequest)
    }
}