package com.rodolfo.mercadolibre.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rodolfo.domain.model.Attributes
import com.rodolfo.mercadolibre.R

class AttributeAdapter : RecyclerView.Adapter<AttributeAdapter.AttributeViewHolder>() {

    private lateinit var attributes: List<Attributes>

    class AttributeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.detail_item_name_text_view)
        val value: TextView = view.findViewById(R.id.detail_item_value_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributeViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.cardview_detail_item, parent, false)
        return AttributeViewHolder(layout)
    }

    override fun getItemCount(): Int = attributes.size

    override fun onBindViewHolder(holder: AttributeViewHolder, position: Int) {
        val attribute = attributes[position]
        attribute.name?.let { holder.name.text = it }
        attribute.valueName?.let { holder.value.text = it }
    }

    fun setAttributes(list: List<Attributes>) {
        attributes = list
        notifyDataSetChanged()
    }
}