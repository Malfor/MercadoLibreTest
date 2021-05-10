package com.rodolfo.domain.repository

import com.rodolfo.domain.model.Product
import com.rodolfo.domain.model.WrapResponse

interface ProductRepository {
    suspend fun getProducts(search: String?) : WrapResponse<List<Product>>
}