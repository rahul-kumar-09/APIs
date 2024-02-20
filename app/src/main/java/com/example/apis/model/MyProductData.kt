package com.example.apis.model

data class MyProductData(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)