package com.rodolfo.domain.model

import com.rodolfo.domain.exception.WrongFieldException
import com.rodolfo.domain.utils.ERROR_AVAILABLE_QUANTITY
import com.rodolfo.domain.utils.ERROR_ID
import com.rodolfo.domain.utils.ERROR_PRICE
import com.rodolfo.domain.utils.ERROR_TITLE

data class Product(val id: String?, val title: String?, val seller: Seller?, val price: Double?, val availableQuantity: Int?, val attributes: List<Attributes>?) {
    init {
        validationFields(id, title, price, availableQuantity)
    }

    private fun validationFields(id: String?, title: String?, price: Double?, availableQuantity: Int?) {
        if (id.isNullOrEmpty())
            throw WrongFieldException(ERROR_ID)
        if (title.isNullOrEmpty())
            throw WrongFieldException(ERROR_TITLE)
        if (price == null)
            throw WrongFieldException(ERROR_PRICE)
        if (availableQuantity == null)
            throw WrongFieldException(ERROR_AVAILABLE_QUANTITY)
    }
}