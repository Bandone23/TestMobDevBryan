package com.bancosantander.testmobdevbryan.data.remote.source

import com.bancosantander.core.extension.await
import com.bancosantander.testmobdevbryan.data.remote.model.BreedsEntry
import com.bancosantander.testmobdevbryan.data.remote.model.BreedsImgEntry
import com.bancosantander.testmobdevbryan.data.remote.net.BreedsApi
import okhttp3.ResponseBody
import retrofit2.Call

open class BreedsRemoteDataSource(
    private val api: BreedsApi
) :BreedsDataStore{
    override suspend fun getBreeds(): BreedsEntry {
        return api.getBreeds().await()!!
    }

    override suspend fun getBreedsImg(name: String): BreedsImgEntry {
        return api.getBreedsImg(name).await()!!
    }

}