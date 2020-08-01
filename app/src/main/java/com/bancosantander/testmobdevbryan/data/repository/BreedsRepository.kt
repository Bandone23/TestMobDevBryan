package com.bancosantander.testmobdevbryan.data.repository

import com.bancosantander.testmobdevbryan.data.remote.model.BreedsEntry
import com.bancosantander.testmobdevbryan.data.remote.model.BreedsImgEntry
import com.bancosantander.testmobdevbryan.data.remote.source.BreedsRemoteDataSource
import okhttp3.ResponseBody
import retrofit2.Call

class BreedsRepository(
    private val remoteDataSource: BreedsRemoteDataSource
) {
    suspend fun getBreeds():BreedsEntry{
        return  remoteDataSource.getBreeds()
    }
    suspend fun getBreedsImg(name:String):BreedsImgEntry {
        return remoteDataSource.getBreedsImg(name)
    }
}