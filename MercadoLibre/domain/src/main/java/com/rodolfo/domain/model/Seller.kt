package com.rodolfo.domain.model

data class Seller(val id: Double, val shop: Shop) {
    init {
        validationField(id, shop)
    }

    private fun validationField(id: Double, shop: Shop) {

    }
}