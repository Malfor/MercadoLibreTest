package com.rodolfo.domain.model

import com.rodolfo.domain.exception.WrongFieldException
import com.rodolfo.domain.utils.EXCEPTION_MESSAGE_NICK_NAME

data class Shop(val nickName: String?) {
    init {
        validationFiled(nickName)
    }

    private fun validationFiled(nickName: String?) {
        if (nickName.isNullOrEmpty())
            throw WrongFieldException(EXCEPTION_MESSAGE_NICK_NAME)
    }
}