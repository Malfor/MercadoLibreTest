package com.rodolfo.domain.model

import com.rodolfo.domain.exception.WrongFieldException
import com.rodolfo.domain.utils.ERROR_NICK_NAME

data class Shop(val nickName: String?){
    init {
        if (nickName.isNullOrEmpty())
            throw WrongFieldException(ERROR_NICK_NAME)
    }
}