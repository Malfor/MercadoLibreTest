package com.rodolfo.domain

import com.rodolfo.domain.model.Attributes
import com.rodolfo.domain.model.Product
import com.rodolfo.domain.model.Seller
import com.rodolfo.domain.model.Shop

val productMockComplete = Product(
    id = "MLA897752664",
    title = "Moto G6 Plus 64 Gb Nimbus 4 Gb Ram",
    seller = Seller(
        id = 143125485,
        shop = Shop(
            nickName = "CLIMAX TIENDAONLINE"
        )
    ),
    price = 41998.99,
    availableQuantity = 8,
    attributes = listOf(
        Attributes(
            name = "Marca",
            valueName = "Motorola"
        ),
        Attributes(
            name = "Modelo de GPU",
            valueName = "Adreno 508"
        )
    )
)