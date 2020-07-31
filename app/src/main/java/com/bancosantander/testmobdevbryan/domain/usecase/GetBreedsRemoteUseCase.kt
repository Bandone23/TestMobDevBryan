package com.bancosantander.testmobdevbryan.domain.usecase

import com.bancosantander.core.coroutines.ResultUnitUseCase
import com.bancosantander.testmobdevbryan.data.remote.model.BreedsEntry
import com.bancosantander.testmobdevbryan.data.repository.BreedsRepository
import kotlinx.coroutines.Dispatchers
import okhttp3.ResponseBody

class GetBreedsRemoteUseCase(
    private val repository: BreedsRepository
):ResultUnitUseCase<BreedsEntry>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(): BreedsEntry? {
        return repository.getBreeds()
    }
}