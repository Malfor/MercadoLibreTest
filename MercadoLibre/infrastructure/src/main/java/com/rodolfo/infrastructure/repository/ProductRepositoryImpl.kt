package com.rodolfo.infrastructure.repository

import com.rodolfo.domain.exception.TechnicalException
import com.rodolfo.domain.model.Product
import com.rodolfo.domain.repository.ProductRepository
import com.rodolfo.infrastructure.mapper.fromSearchDtoToDomainList
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val retrofitRepository: RetrofitRepository
) : ProductRepository {

    override suspend fun getProducts(search: String?): List<Product>? {
        val productService: ProductService = retrofitRepository.getRetrofit().create(ProductService::class.java)
        var productList: List<Product>? = null
        try {
            val response = productService.getProducts(search)
            val responseBody = response.body()
            responseBody?.let { searchDto ->
                productList = fromSearchDtoToDomainList(searchDto)
            }
        } catch (ex: Exception) {
            throw TechnicalException(ex)
        }
        return productList
    }

}