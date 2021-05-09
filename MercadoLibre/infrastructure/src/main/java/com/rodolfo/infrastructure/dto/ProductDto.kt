package com.rodolfo.infrastructure.dto

import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("id") val id: String? = "",
    @SerializedName("title") val title: String? = "",
    @SerializedName("seller") val seller: SellerDto? = null,
    @SerializedName("price") val price: Double,
    @SerializedName("available_quantity") val availableQuantity: Int,
    @SerializedName("attributes") val attributes: List<AttributesDto>? = null
)