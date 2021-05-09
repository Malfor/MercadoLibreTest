package com.rodolfo.infrastructure.mapper

import com.rodolfo.domain.model.Attributes
import com.rodolfo.domain.model.Product
import com.rodolfo.domain.model.Seller
import com.rodolfo.domain.model.Shop
import com.rodolfo.infrastructure.dto.*

private fun fromProductDtoToDomain(productDto: ProductDto) : Product {
    return Product(
        id = productDto.id,
        title = productDto.title,
        seller = productDto.seller?.let { fromSellerDtoToDomain(it) } ?: run { null },
        price = productDto.price,
        availableQuantity = productDto.availableQuantity,
        attributes = productDto.attributes?.let { attributes -> attributes.map { fromAttributesDtoToDomain(it) } } ?: run { null }
    )
}

private fun fromSellerDtoToDomain(sellerDto: SellerDto) : Seller {
    return Seller(
        id = sellerDto.id,
        shop = sellerDto.shop?.let { fromShopDtoToDomain(it) } ?: run { null }
    )
}

private fun fromShopDtoToDomain(shopDto: ShopDto) : Shop {
    return Shop(
        nickName = shopDto.nickName
    )
}

private fun fromAttributesDtoToDomain(attributesDto: AttributesDto) : Attributes {
    return Attributes(
        name = attributesDto.name,
        valueName = attributesDto.valueName
    )
}

fun fromSearchDtoToDomainList(searchDto: SearchDto) : List<Product>? {
    return searchDto.result?.let { list -> list.map { fromProductDtoToDomain(it) } } ?: run { null }
}