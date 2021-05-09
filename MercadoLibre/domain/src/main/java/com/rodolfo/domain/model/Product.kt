package com.rodolfo.domain.model

import com.rodolfo.domain.exception.WrongFieldException
import com.rodolfo.domain.utils.*

data class Product(
    val id: String?,
    val title: String?,
    val seller: Seller?,
    val price: Double,
    val availableQuantity: Int,
    val attributes: List<Attributes>?
) {
    init {
        validationFields(id, title, seller, price, availableQuantity, attributes)
    }

    private fun validationFields(
        id: String?,
        title: String?,
        seller: Seller?,
        price: Double,
        availableQuantity: Int,
        attributes: List<Attributes>?
    ) {
        if (id.isNullOrEmpty())
            throw WrongFieldException(EXCEPTION_MESSAGE_ID)
        if (title.isNullOrEmpty())
            throw WrongFieldException(EXCEPTION_MESSAGE_TITLE)
        if (seller == null)
            throw WrongFieldException(EXCEPTION_MESSAGE_SELLER)
        if (price <= 0)
            throw WrongFieldException(EXCEPTION_MESSAGE_PRICE)
        if (availableQuantity >= 0)
            throw WrongFieldException(EXCEPTION_MESSAGE_AVAILABLE_QUANTITY)
        if (attributes == null)
            throw WrongFieldException(EXCEPTION_MESSAGE_ATTRIBUTES)
    }
}