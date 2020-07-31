package com.bancosantander.testmobdevbryan.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bancosantander.testmobdevbryan.R
import com.bancosantander.testmobdevbryan.databinding.ItemBreedsBinding
import com.bancosantander.testmobdevbryan.presentation.adapter.holder.BreedsNHolder

class BreedAdapter(
    private var items: ArrayList<String>,
    private val clickListener: (String, Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding: ItemBreedsBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_breeds,
                parent,
                false
            )
        return BreedsNHolder(itemBinding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        holder as BreedsNHolder
        holder.bindEvent(item, clickListener)
    }

}