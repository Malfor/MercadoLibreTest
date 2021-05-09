package com.rodolfo.domain.repository

import com.rodolfo.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(search: String?) : List<Product>?
}