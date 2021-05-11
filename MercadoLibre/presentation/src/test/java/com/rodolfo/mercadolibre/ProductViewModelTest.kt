package com.rodolfo.mercadolibre

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.rodolfo.domain.model.Product
import com.rodolfo.domain.model.WrapResponse
import com.rodolfo.domain.service.ProductService
import com.rodolfo.mercadolibre.viewmodel.ProductViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class ProductViewModelTest {

    @get:Rule
    val testRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var productService: ProductService

    @Mock
    private lateinit var mockIsLoading: Observer<Boolean>

    @Mock
    private lateinit var mockProductService: Observer<WrapResponse<List<Product>>>

    private lateinit var productViewModel: ProductViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this@ProductViewModelTest)
        productViewModel = ProductViewModel(
            productService = productService
        ).apply {
            onIsLoading.observeForever(mockIsLoading)
            onGetProduct.observeForever(mockProductService)
            coroutineContext = TestCoroutineScope().coroutineContext
        }
    }

    @Test
    fun `When getProducts search empty return empty list`() = runBlockingTest {
        //Arrange
        Mockito.`when`(productService.getProducts(searchEmpty)).thenReturn(wrapResponseEmptyList)
        //Act
        productViewModel.getProducts(search = searchEmpty)
        //Asserts
        Mockito.verify(mockIsLoading).onChanged(true)
        Mockito.verify(mockIsLoading).onChanged(false)
        Mockito.verifyNoMoreInteractions(mockIsLoading)
        Mockito.verify(mockProductService).onChanged(wrapResponseEmptyList)
    }

    @Test
    fun `When getProducts search TV return product list`() = runBlockingTest {
        //Arrange
        Mockito.`when`(productService.getProducts(searchTV)).thenReturn(wrapResponseWithProductList)
        //Act
        productViewModel.getProducts(search = searchTV)
        //Asserts
        Mockito.verify(mockIsLoading).onChanged(true)
        Mockito.verify(mockIsLoading).onChanged(false)
        Mockito.verifyNoMoreInteractions(mockIsLoading)
        Mockito.verify(mockProductService).onChanged(wrapResponseWithProductList)
    }

    @Test
    fun `When getProducts search error return wrap with error`() = runBlockingTest {
        //Arrange
        Mockito.`when`(productService.getProducts(searchError)).thenReturn(wrapResponseWithError)
        //Act
        productViewModel.getProducts(search = searchError)
        //Asserts
        Mockito.verify(mockIsLoading).onChanged(true)
        Mockito.verify(mockIsLoading).onChanged(false)
        Mockito.verifyNoMoreInteractions(mockIsLoading)
        Mockito.verify(mockProductService).onChanged(wrapResponseWithError)
    }

}