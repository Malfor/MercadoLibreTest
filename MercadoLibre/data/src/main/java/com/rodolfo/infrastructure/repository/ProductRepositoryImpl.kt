package com.rodolfo.infrastructure.repository

import com.rodolfo.domain.exception.WrongFieldException
import com.rodolfo.domain.model.Product
import com.rodolfo.domain.model.WrapResponse
import com.rodolfo.domain.repository.ProductRepository
import com.rodolfo.infrastructure.mapper.fromSearchDtoToDomainList
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

const val ERROR_CONNECTION_INTERNET = "La conexion a internet no está activiada"
const val ERROR_TIME_OUT = "Tiempo de espera del servicio agotado"

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
        } catch (ex: UnknownHostException) {
            wrapResponse.error = ERROR_CONNECTION_INTERNET
        } catch (ex: SocketTimeoutException) {
            wrapResponse.error = ERROR_TIME_OUT
        } catch (ex: WrongFieldException) {
            wrapResponse.error = ex.message
        } catch (ex: Exception) {
            wrapResponse.error = ex.message
        }
        return wrapResponse
    }

}