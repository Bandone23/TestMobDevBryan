package com.bancosantander.testmobdevbryan.presentation.fragment.breeds

import androidx.lifecycle.ViewModel
import com.bancosantander.core.extension.LiveResult
import com.bancosantander.testmobdevbryan.domain.model.Breeds
import com.bancosantander.testmobdevbryan.domain.usecase.GetBreedsRemoteUseCase

class BreedsViewModel(
    private val getBreedsRemoteUseCase: GetBreedsRemoteUseCase
):ViewModel() {
    val breedsLiveData = LiveResult<Breeds>()

    fun getBreeds(){ getBreedsRemoteUseCase.execute(liveData = breedsLiveData) }




}