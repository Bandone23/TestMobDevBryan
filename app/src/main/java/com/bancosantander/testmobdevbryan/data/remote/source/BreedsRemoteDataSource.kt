package com.bancosantander.testmobdevbryan.data.remote.source

import com.bancosantander.core.extension.await
import com.bancosantander.testmobdevbryan.data.remote.model.BreedsEntry
import com.bancosantander.testmobdevbryan.data.remote.net.BreedsApi
import okhttp3.ResponseBody
import retrofit2.Call

class BreedsRemoteDataSource(
    private val api: BreedsApi
) {
    suspend fun getBreeds(): BreedsEntry {
        return api.getBreeds().await()!!
    }
}