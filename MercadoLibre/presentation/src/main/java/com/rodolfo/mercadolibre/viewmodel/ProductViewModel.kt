package com.rodolfo.mercadolibre.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodolfo.domain.model.Product
import com.rodolfo.domain.model.WrapResponse
import com.rodolfo.domain.service.ProductService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ProductViewModel @ViewModelInject constructor(
    private val productService: ProductService
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.IO

    private val isLoading = MutableLiveData<Boolean>()
    val onIsLoading: LiveData<Boolean> = isLoading

    private val getProducts = MutableLiveData<WrapResponse<List<Product>>>()
    val onGetProduct: LiveData<WrapResponse<List<Product>>> = getProducts

    fun getProducts(search: String) {
        viewModelScope.launch(coroutineContext) {
            isLoading.postValue(true)
            getProducts.postValue(productService.getProducts(search))
            isLoading.postValue(false)
        }
    }
}