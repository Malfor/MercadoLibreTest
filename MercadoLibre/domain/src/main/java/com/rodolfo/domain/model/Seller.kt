package com.rodolfo.domain.model

import com.rodolfo.domain.exception.WrongFieldException
import com.rodolfo.domain.utils.ERROR_ID

data class Seller(val id: Int?, val shop: Shop?) {
    init {
        if (id == null)
            throw WrongFieldException(ERROR_ID)
    }
}