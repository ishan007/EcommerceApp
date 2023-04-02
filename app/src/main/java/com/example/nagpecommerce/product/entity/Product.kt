package com.example.nagpecommerce.product.entity

data class Product(val name: String = "Test",
                   val description: String = "Description",
                   val category: String = "Cloth",
                   val price: String = "$ 700",
                   val image: String = "https://shop.azelab.com/images/products/thumbs/1.jpg")