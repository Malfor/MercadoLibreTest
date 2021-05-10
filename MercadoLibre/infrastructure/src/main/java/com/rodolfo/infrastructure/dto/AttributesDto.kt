package com.rodolfo.infrastructure.dto

import com.google.gson.annotations.SerializedName

data class AttributesDto(
    @SerializedName("name") val name: String?,
    @SerializedName("value_name") val valueName: String?)