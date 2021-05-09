package com.rodolfo.domain.model

data class Attributes(val name: String, val valueName: String) {
    init {
        validateFields(name, valueName)
    }

    private fun validateFields(name: String, valueName: String) {

    }
}