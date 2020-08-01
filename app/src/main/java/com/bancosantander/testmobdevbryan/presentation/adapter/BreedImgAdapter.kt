package com.bancosantander.testmobdevbryan.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bancosantander.testmobdevbryan.R
import com.bancosantander.testmobdevbryan.databinding.ItemBreedsBinding
import com.bancosantander.testmobdevbryan.databinding.ItemImgBreedsBinding
import com.bancosantander.testmobdevbryan.presentation.adapter.holder.BreedsImgHolder
import com.bancosantander.testmobdevbryan.presentation.adapter.holder.BreedsNHolder

class BreedImgAdapter(
    private val items:ArrayList<String>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding: ItemImgBreedsBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_img_breeds,
                parent,
                false
            )
        return BreedsImgHolder(itemBinding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        holder as BreedsImgHolder
        holder.bindEvent(item)
    }
}