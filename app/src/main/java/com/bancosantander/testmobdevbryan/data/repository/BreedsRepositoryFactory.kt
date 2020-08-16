package com.bancosantander.testmobdevbryan.data.repository

import com.bancosantander.testmobdevbryan.data.remote.source.BreedsDataStore
import com.bancosantander.testmobdevbryan.data.remote.source.BreedsRemoteDataSource

open class BreedsRepositoryFactory(
    private val remoteDataSource: BreedsRemoteDataSource
) {
    fun getRemoteDataSource():BreedsDataStore = remoteDataSource
}