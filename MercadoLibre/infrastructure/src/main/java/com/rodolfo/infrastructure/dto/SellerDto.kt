package com.rodolfo.infrastructure.dto

import com.google.gson.annotations.SerializedName

data class SellerDto(
    @SerializedName("id") val id: Int,
    @SerializedName("eshop") val shop: ShopDto? =  null)