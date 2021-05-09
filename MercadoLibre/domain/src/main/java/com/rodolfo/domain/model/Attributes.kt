package com.rodolfo.domain.model

import com.rodolfo.domain.exception.WrongFieldException
import com.rodolfo.domain.utils.EXCEPTION_MESSAGE_NAME
import com.rodolfo.domain.utils.EXCEPTION_MESSAGE_VALUE_NAME

data class Attributes(val name: String, val valueName: String) {
    init {
        validateFields(name, valueName)
    }

    private fun validateFields(name: String, valueName: String) {
        if (name.isEmpty())
            throw WrongFieldException(EXCEPTION_MESSAGE_NAME)
        if (valueName.isEmpty())
            throw WrongFieldException(EXCEPTION_MESSAGE_VALUE_NAME)
    }
}