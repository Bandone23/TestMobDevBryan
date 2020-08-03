package com.bancosantander.testmobdevbryan.domain.usecase

import com.bancosantander.core.coroutines.ResultUseCase
import com.bancosantander.testmobdevbryan.data.repository.BreedsRepository
import com.bancosantander.testmobdevbryan.domain.model.BreedsImg
import kotlinx.coroutines.Dispatchers

class GetBreedsImgRemoteUseCase(
    private  val repository: BreedsRepository
) : ResultUseCase<String, BreedsImg>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(params: String): BreedsImg? {
        return repository.getBreedsImg(params)
    }
}