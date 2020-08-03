package com.bancosantander.testmobdevbryan.presentation.fragment.breedsDetail

import androidx.lifecycle.ViewModel
import com.bancosantander.core.extension.LiveResult
import com.bancosantander.testmobdevbryan.domain.model.BreedsImg
import com.bancosantander.testmobdevbryan.domain.usecase.GetBreedsImgRemoteUseCase

class BreedsImgViewModel(

    private val getBreedsImgRemoteUseCase: GetBreedsImgRemoteUseCase
) : ViewModel() {
    val breedImgLiveData = LiveResult<BreedsImg>()
    fun getBreedsImg(name: String) {
        getBreedsImgRemoteUseCase.execute(
            liveData = breedImgLiveData, params = name
        )
    }
}