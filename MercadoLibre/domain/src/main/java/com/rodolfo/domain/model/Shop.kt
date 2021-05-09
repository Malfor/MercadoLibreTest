package com.rodolfo.domain.model

data class Shop(val nickName: String) {
    init {
        validationFiled(nickName)
    }

    private fun validationFiled(nickName: String) {

    }
}