package com.rodolfo.mercadolibre.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rodolfo.domain.model.Product

class SharedViewModel : ViewModel() {
    val itemSelected = MutableLiveData<Product>()

    fun setItemSelected(product: Product) {
        itemSelected.value = product
    }
}