package com.example.nagpecommerce.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nagpecommerce.profile.view.ProfileFragment
import com.example.nagpecommerce.R
import com.example.nagpecommerce.product.view.ProductListScreen
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomNav()
        attachFragment(ProductListScreen())
    }


    private fun attachFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit()
    }

    private fun initBottomNav(){
        val bottomNav = findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> attachFragment(ProductListScreen())
                R.id.navigation_me -> attachFragment(ProfileFragment())
            }
            true
        }
    }
}