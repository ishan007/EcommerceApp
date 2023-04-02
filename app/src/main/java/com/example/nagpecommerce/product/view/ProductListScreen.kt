package com.example.nagpecommerce.product.view

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nagpecommerce.R
import com.example.nagpecommerce.product.entity.Product
import com.example.nagpecommerce.product.presenter.ProductListPresenter
import com.example.nagpecommerce.product.repository.ProductListRepository
import com.example.nagpecommerce.retrofit.ApiClient
import com.example.nagpecommerce.retrofit.SearchApiClient

class ProductListScreen : AppCompatActivity(), ProductListView{

    private val adapter = ProductListAdapter()
    private val presenter = ProductListPresenter(this, ProductListRepository(ApiClient.create(SearchApiClient::class.java)))
    private lateinit var loader: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list_screen)
        init()
    }

    private fun init(){
        loader = findViewById(R.id.product_loader)
        val recyclerView = findViewById<RecyclerView>(R.id.product_list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val searchView = findViewById<EditText>(R.id.search_view)
        findViewById<Button>(R.id.search_button).setOnClickListener {
            val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
            loader.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                presenter.searchProduct(searchView.text.toString())
            }, 1000)
        }
    }


    override fun onSearchResponse(products: List<Product>) {
        loader.visibility = View.GONE
        adapter.updateData(products)
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}