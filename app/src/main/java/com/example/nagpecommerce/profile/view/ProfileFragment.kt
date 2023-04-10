package com.example.nagpecommerce.profile.view

import android.app.ActivityOptions
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.example.nagpecommerce.R
import com.example.nagpecommerce.login.view.*
import com.example.nagpecommerce.main.MainActivity
import com.example.nagpecommerce.profile.User
import com.example.nagpecommerce.profile.presenter.ProfilePresenter
import com.example.nagpecommerce.profile.repository.ProfileRepository
import com.example.nagpecommerce.retrofit.ApiClient
import com.example.nagpecommerce.retrofit.UserApiClient

class ProfileFragment : Fragment(), ProfileView{

    private lateinit var userNameTv: TextView
    private val presenter = ProfilePresenter(this, ProfileRepository(ApiClient.create(UserApiClient::class.java)))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userNameTv = view.findViewById(R.id.name_tv)
        view.findViewById<Button>(R.id.logout_button).setOnClickListener {
            context?.getSharedPreferences(USER_PREF, AppCompatActivity.MODE_PRIVATE)?.edit {
                putString(ACCESS_TOKEN, "")
                putString(REFRESH_TOKEN, "")
            }
            val intent = Intent(context, LoginScreen::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
        }
        updateUI()
    }

    override fun showUser(user: User) {
        userNameTv.text = user.name
    }

    override fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }


    private fun updateUI(){
        val email: String = context?.getSharedPreferences(USER_PREF, MODE_PRIVATE)?.getString(EMAIL, "") ?: ""
        userNameTv.text = email
//        if(auth != ""){
//            presenter.getUser(auth)
//        }
    }

}