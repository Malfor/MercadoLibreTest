package com.rodolfo.domain.service

import com.rodolfo.domain.BaseTest
import com.rodolfo.domain.model.Product
import com.rodolfo.domain.model.WrapResponse
import com.rodolfo.domain.repository.ProductRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class ProductServiceTest : BaseTest() {

    @Test
    fun `it should return a wrapResponse with data`() = runBlocking  {
        // Assert
        val repository = Mockito.mock(ProductRepository::class.java)
        val search = "TV"
        val wrapResponse = WrapResponse(data = listOf(product))
        Mockito.`when`(repository.getProducts(search)).thenReturn(wrapResponse)
        val productService = ProductService(repository)
        // Act
        val productList = productService.getProducts(search).data
        //Assert
        Assert.assertEquals(wrapResponse.data?.size, productList?.size)
    }

    @Test
    fun `it should return a wrapResponse without data`() = runBlocking  {
        // Assert
        val repository = Mockito.mock(ProductRepository::class.java)
        val search = ""
        val wrapResponse = WrapResponse<List<Product>>(data = emptyList())
        Mockito.`when`(repository.getProducts(search)).thenReturn(wrapResponse)
        val productService = ProductService(repository)
        // Act
        val productList = productService.getProducts(search).data
        //Assert
        Assert.assertEquals(wrapResponse.data?.isEmpty(), productList?.isEmpty())
    }
}