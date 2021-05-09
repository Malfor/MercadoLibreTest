package com.rodolfo.domain.model

data class Product(
    val id: String?,
    val title: String?,
    val seller: Seller?,
    val price: Double,
    val availableQuantity: Int,
    val attributes: List<Attributes>?
)