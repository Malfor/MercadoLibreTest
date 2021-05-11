package com.rodolfo.mercadolibre

import com.rodolfo.domain.model.*

const val searchEmpty = ""
const val searchTV = "TV"
const val searchError = "error"
const val idString = "mock123"
const val title = "TV Samsung mock"
const val idInt = 101010
const val nickname = "Samgun mock"
const val price = 100.0
const val availableQuantity = 8
const val name = "Marca"
const val valueName = "Samsung"

private val attribute = Attributes(name = name, valueName = valueName)
private val shop = Shop(nickName = nickname)
private val seller = Seller(id = idInt, shop = shop)
val productMock = Product(
    id = idString,
    title = title,
    seller = seller,
    price = price,
    availableQuantity = availableQuantity,
    attributes = listOf(attribute)
)

val wrapResponseEmptyList = WrapResponse<List<Product>>(data = emptyList())
val wrapResponseWithProductList = WrapResponse(data = listOf(productMock))
val wrapResponseWithError = WrapResponse<List<Product>>(error = "error mock")
