package com.rodolfo.infrastructure.mapper

import com.rodolfo.domain.model.Attributes
import com.rodolfo.domain.model.Product
import com.rodolfo.domain.model.Seller
import com.rodolfo.domain.model.Shop
import com.rodolfo.infrastructure.dto.ProductDto
import com.rodolfo.infrastructure.dto.SearchDto

private fun fromProductDtoToDomain(productDto: ProductDto) : Product {
    return Product(
        id = productDto.id,
        title = productDto.title,
        seller = productDto.seller?.let { sellerDto ->
            Seller(
            id = sellerDto.id,
            shop = sellerDto.shop?.let { shopDto ->
                Shop(
                    nickName = shopDto.nickName
                )
            } ?: run { null }
        ) } ?: run { null },
        price = productDto.price,
        availableQuantity = productDto.availableQuantity,
        attributes = productDto.attributes?.let { attributesDto ->
            attributesDto.map { attributeDto ->
                Attributes(
                    name = attributeDto.name,
                    valueName = attributeDto.valueName
                )
            } } ?: run { null }
    )
}

fun fromSearchDtoToDomainList(searchDto: SearchDto) : List<Product>? {
    return searchDto.result?.let { list -> list.map { fromProductDtoToDomain(it) } }
}