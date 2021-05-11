package com.rodolfo.infrastructure.dto

import com.google.gson.annotations.SerializedName

data class SearchDto(
    @SerializedName("results") val result: List<ProductDto>?
)