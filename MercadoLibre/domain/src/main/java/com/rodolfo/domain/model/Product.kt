package com.rodolfo.domain.model

data class Product(
    val id: String,
    val title: String,
    val seller: Seller,
    val price: Double,
    val availableQuantity: Int,
    val attributes: List<Attributes>
) {
    init {
        validationFields(id, title, seller, price, availableQuantity, attributes)
    }

    private fun validationFields(
        id: String,
        title: String,
        seller: Seller,
        price: Double,
        availableQuantity: Int,
        attributes: List<Attributes>
    ) {

    }
}