package com.bancosantander.testmobdevbryan.presentation.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.bancosantander.testmobdevbryan.databinding.ItemImgBreedsBinding
import com.bancosantander.testmobdevbryan.util.getImgPicasso

class BreedsImgHolder(
    private val binding: ItemImgBreedsBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bindEvent(breedsImg:String){
        getImgPicasso(breedsImg,binding.imgBreeds)
        binding.executePendingBindings()
    }
}