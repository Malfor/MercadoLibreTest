package com.rodolfo.domain.model

import com.rodolfo.domain.exception.WrongFieldException
import com.rodolfo.domain.utils.EXCEPTION_MESSAGE_SHOP

data class Seller(val id: Double, val shop: Shop?) {
    init {
        validationField(shop)
    }

    private fun validationField(shop: Shop?) {
        if (shop == null)
            throw WrongFieldException(EXCEPTION_MESSAGE_SHOP)
    }
}