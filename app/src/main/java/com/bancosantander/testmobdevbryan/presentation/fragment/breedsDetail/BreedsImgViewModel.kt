package com.bancosantander.testmobdevbryan.presentation.fragment.breedsDetail

import androidx.lifecycle.ViewModel
import com.bancosantander.core.extension.LiveResult
import com.bancosantander.testmobdevbryan.data.remote.model.BreedsImgEntry
import com.bancosantander.testmobdevbryan.domain.usecase.GetBreedsImgRemoteUseCase
import com.bancosantander.testmobdevbryan.presentation.adapter.BreedImgAdapter

class BreedsImgViewModel(

    private val getBreedsImgRemoteUseCase: GetBreedsImgRemoteUseCase
) : ViewModel() {
    val breedImgLiveData = LiveResult<BreedsImgEntry>()
    fun getBreedsImg(name: String) {
        getBreedsImgRemoteUseCase.execute(
            liveData = breedImgLiveData, params = name
        )
    }
}