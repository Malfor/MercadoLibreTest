package com.rodolfo.domain.model

data class WrapResponse<T>(var data: T? = null, var error: String? = null)