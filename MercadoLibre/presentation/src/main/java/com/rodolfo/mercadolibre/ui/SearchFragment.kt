package com.rodolfo.mercadolibre.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rodolfo.domain.model.Product
import com.rodolfo.mercadolibre.adapter.ProductAdapter
import com.rodolfo.mercadolibre.databinding.FragmentSearchBinding
import com.rodolfo.mercadolibre.viewmodel.ProductViewModel
import com.rodolfo.mercadolibre.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var binding: FragmentSearchBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        addSubscribed()
        setOnClickListener()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configRecyclerView()
    }

    private fun configRecyclerView() {
        recyclerView = binding.searchRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun addSubscribed() {
        viewModel.onIsLoading.observe(viewLifecycleOwner, Observer<Boolean> { result -> onIsLoading(result) })
        viewModel.onGetProduct.observe(viewLifecycleOwner, Observer<List<Product>> { result -> onGetProduct(result) })
    }

    private fun onGetProduct(result: List<Product>?) {
        result?.let {list ->
            if (list.isNotEmpty()) {
                binding.searchEmptyImageView.visibility = View.GONE
                val productAdapter = ProductAdapter( onClickCard = { sharedViewModel.setItemSelected(it) })
                productAdapter.setProductList(list)
                recyclerView.adapter = productAdapter
                binding.searchRecyclerView.visibility = View.VISIBLE
            }
            else {
                binding.searchRecyclerView.visibility = View.GONE
                binding.searchEmptyImageView.visibility = View.VISIBLE
            }
        } ?: run {
            binding.searchRecyclerView.visibility = View.GONE
            binding.searchEmptyImageView.visibility = View.VISIBLE
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

    private fun setOnClickListener() {
        binding.searchTextInputLayout.setEndIconOnClickListener { searchProduct() }
    }

    private fun searchProduct() {
        binding.searchTextInputEditText.text?.let { viewModel.getProducts(it.toString().trim()) }
    }
}