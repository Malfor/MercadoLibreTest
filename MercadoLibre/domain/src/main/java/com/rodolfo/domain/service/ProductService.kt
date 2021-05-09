package com.rodolfo.domain.service

import com.rodolfo.domain.model.Product
import com.rodolfo.domain.repository.ProductRepository
import javax.inject.Inject

class ProductService @Inject constructor(private val productRepository: ProductRepository) {
    suspend fun getProducts(search: String) : List<Product>? {
        return productRepository.getProducts(search)
    }
}