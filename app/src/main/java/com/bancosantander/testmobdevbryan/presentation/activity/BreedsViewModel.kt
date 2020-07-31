package com.bancosantander.testmobdevbryan.presentation.activity

import androidx.lifecycle.ViewModel
import com.bancosantander.core.extension.LiveResult
import com.bancosantander.testmobdevbryan.data.remote.model.BreedsEntry
import com.bancosantander.testmobdevbryan.domain.usecase.GetBreedsRemoteUseCase
import com.bancosantander.testmobdevbryan.presentation.adapter.BreedAdapter

class BreedsViewModel(
    private val getBreedsRemoteUseCase: GetBreedsRemoteUseCase
):ViewModel() {
    lateinit var adapter: BreedAdapter
    val breedsLiveData = LiveResult<BreedsEntry>()

    fun getBreeds(){ getBreedsRemoteUseCase.execute(liveData = breedsLiveData) }




}