package com.bancosantander.testmobdevbryan.presentation.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.bancosantander.testmobdevbryan.data.remote.model.BreedsEntry
import com.bancosantander.testmobdevbryan.databinding.ItemBreedsBinding
class BreedsNHolder (
    private val binding: ItemBreedsBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bindEvent(breedsData: String, clickListener: (String, Int) -> Unit) {
        binding.textBreeds.text =  breedsData
        binding.containerCard.setOnClickListener {  clickListener(breedsData, binding.containerCard.id) }
        binding.executePendingBindings()
    }

}