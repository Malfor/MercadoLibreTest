package com.rodolfo.mercadolibre.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rodolfo.domain.model.Attributes
import com.rodolfo.domain.model.Product
import com.rodolfo.mercadolibre.adapter.AttributeAdapter
import com.rodolfo.mercadolibre.databinding.FragmentProductDetailBinding
import com.rodolfo.mercadolibre.viewmodel.SharedViewModel

class ProductDetailFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var binding: FragmentProductDetailBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.itemSelected.observe(viewLifecycleOwner, Observer { setInfo(it) })
    }

    private fun setInfo(product: Product?) {
        product?.let {
            with(binding) {
                detailTitleTextView.text = it.title
                detailSoldByTextView.text = it.seller?.shop?.nickName
                detailPriceTextView.text = it.price.toString()
                detailQuantityTextView.text = it.availableQuantity.toString()
                configureRecyclerView(it.attributes)
            }
        }
    }

    private fun configureRecyclerView(attributes: List<Attributes>?) {
        recyclerView = binding.detailRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        attributes?.let { list ->
            if (list.isNotEmpty()) {
                val attributeAdapter = AttributeAdapter()
                attributeAdapter.setAttributes(list)
                recyclerView.adapter = attributeAdapter
            }
        }

    }



}