package com.bancosantander.testmobdevbryan.domain.usecase

import com.bancosantander.core.coroutines.ResultUnitUseCase
import com.bancosantander.testmobdevbryan.data.repository.BreedsRepository
import com.bancosantander.testmobdevbryan.domain.model.Breeds
import kotlinx.coroutines.Dispatchers

class GetBreedsRemoteUseCase(
    private val repository: BreedsRepository
):ResultUnitUseCase<Breeds>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(): Breeds? {
        return repository.getBreeds()
    }
}