package com.bancosantander.testmobdevbryan.domain.usecase

import com.bancosantander.core.coroutines.ResultUnitUseCase
import com.bancosantander.core.coroutines.ResultUseCase
import com.bancosantander.testmobdevbryan.data.repository.BreedsRepository
import com.bancosantander.testmobdevbryan.data.repository.BreedsRepositoryIntrf
import com.bancosantander.testmobdevbryan.domain.model.Breeds
import kotlinx.coroutines.Dispatchers

open class GetBreedsRemoteUseCase(
    private val repository: BreedsRepositoryIntrf
): ResultUseCase<Unit,Breeds>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(params: Unit): Breeds? {
        return repository.getBreeds()
    }
}