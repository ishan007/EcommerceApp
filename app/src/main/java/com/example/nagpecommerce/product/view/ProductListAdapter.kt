package com.example.nagpecommerce.product.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nagpecommerce.R
import com.example.nagpecommerce.product.entity.Product

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ViewHolder>(){

    private val products: ArrayList<Product> = arrayListOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val imageIv: ImageView = view.findViewById(R.id.product_image_view)
        private val priceTv: TextView = view.findViewById(R.id.price_tv)
        private val nameTv: TextView = view.findViewById(R.id.name_tv)

        fun bind(product: Product){
            priceTv.text = product.price
            nameTv.text = product.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    fun updateData(products: List<Product>){
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

}