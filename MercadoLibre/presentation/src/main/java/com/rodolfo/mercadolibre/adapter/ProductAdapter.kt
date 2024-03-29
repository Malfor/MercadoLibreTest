package com.rodolfo.mercadolibre.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.rodolfo.domain.model.Product
import com.rodolfo.mercadolibre.R

class ProductAdapter(var onClickCard: (Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private lateinit var productList: List<Product>

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: ConstraintLayout = view.findViewById(R.id.search_item_container)
        val title: TextView = view.findViewById(R.id.search_item_title_text_view)
        val price: TextView = view.findViewById(R.id.search_item_price_text_view)
        val soldBy: TextView = view.findViewById(R.id.search_item_sold_by_text_view)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_search_item, parent, false)
        return ProductViewHolder(layout)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        product.title?.let { holder.title.text = it }
        product.price.let { holder.price.text = it.toString() }
        product.seller?.shop?.nickName?.let { holder.soldBy.text = it }
        holder.container.setOnClickListener {
            onClickCard(product)
            holder.itemView.findNavController().navigate(R.id.action_searchFragment_to_productDetailFragment)
        }
    }

    fun setProductList(list: List<Product>) {
        productList = list
        notifyDataSetChanged()
    }

}