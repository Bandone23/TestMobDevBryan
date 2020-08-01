package com.bancosantander.testmobdevbryan.domain.usecase

import com.bancosantander.core.coroutines.ResultUseCase
import com.bancosantander.testmobdevbryan.data.remote.model.BreedsImgEntry
import com.bancosantander.testmobdevbryan.data.repository.BreedsRepository
import kotlinx.coroutines.Dispatchers

class GetBreedsImgRemoteUseCase(
    private  val repository: BreedsRepository
) : ResultUseCase<String,BreedsImgEntry>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(params: String): BreedsImgEntry? {
        return repository.getBreedsImg(params)
    }
}