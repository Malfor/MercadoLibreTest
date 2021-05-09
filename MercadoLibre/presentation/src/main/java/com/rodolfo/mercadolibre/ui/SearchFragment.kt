package com.rodolfo.mercadolibre.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.rodolfo.domain.model.Product
import com.rodolfo.mercadolibre.databinding.FragmentSearchBinding
import com.rodolfo.mercadolibre.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModels()

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        addSubscribed()
        return binding.root
    }

    private fun addSubscribed() {
        viewModel.onIsLoading.observe(viewLifecycleOwner, Observer<Boolean> { result -> onIsLoading(result) })
        viewModel.onGetProduct.observe(viewLifecycleOwner, Observer<List<Product>> { result -> onGetProduct(result) })
    }

    private fun onGetProduct(result: List<Product>?) {
        result?.let {list ->

        }
    }

    private fun onIsLoading(result: Boolean) {
        with (binding) {
            if (result)
                progress.visibility = View.VISIBLE
            else
                progress.visibility = View.GONE
        }
    }
}