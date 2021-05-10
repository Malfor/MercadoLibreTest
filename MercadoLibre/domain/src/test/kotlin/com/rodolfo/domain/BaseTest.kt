package com.rodolfo.domain

import com.rodolfo.domain.model.Attributes
import com.rodolfo.domain.model.Product
import com.rodolfo.domain.model.Seller
import com.rodolfo.domain.model.Shop

abstract class BaseTest {

    protected var idStrig: String? = "mock123"
    protected var title: String? = "TV Samsung mock"
    protected var idInt: Int? = 101010
    protected var nickname: String? = "Samgun mock"
    protected var price: Double? = 100.0
    protected var availableQuantity: Int? = 8
    protected var name: String? = "Marca"
    protected var valueName: String? = "Samsung"

    private val attribute = Attributes(name = name, valueName = valueName)
    private val shop = Shop(nickName = nickname)
    private val seller = Seller(id = idInt, shop = shop)
    protected val product = Product(
        id = idStrig,
        title = title,
        seller = seller,
        price = price,
        availableQuantity = availableQuantity,
        attributes = listOf(attribute)
    )
}