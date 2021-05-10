package com.rodolfo.infrastructure.repository

import com.rodolfo.domain.model.Product
import com.rodolfo.domain.model.WrapResponse
import com.rodolfo.domain.repository.ProductRepository
import com.rodolfo.infrastructure.mapper.fromSearchDtoToDomainList
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val retrofitRepository: RetrofitRepository
) : ProductRepository {

    override suspend fun getProducts(search: String?): WrapResponse<List<Product>> {
        val productService: ProductService = retrofitRepository.getRetrofit().create(ProductService::class.java)
        val wrapResponse = WrapResponse<List<Product>>()
        try {
            val response = productService.getProducts(search)
            val responseBody = response.body()
            responseBody?.let { searchDto ->
                wrapResponse.data = fromSearchDtoToDomainList(searchDto)
            }
        } catch (ex: Exception) {
            wrapResponse.error = ex.message
        }
        return wrapResponse
    }

}