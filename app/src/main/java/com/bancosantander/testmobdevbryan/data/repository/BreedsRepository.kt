package com.bancosantander.testmobdevbryan.data.repository


import com.bancosantander.testmobdevbryan.data.remote.model.toBreeds
import com.bancosantander.testmobdevbryan.data.remote.model.toBreedsImg
import com.bancosantander.testmobdevbryan.data.remote.source.BreedsRemoteDataSource
import com.bancosantander.testmobdevbryan.domain.model.Breeds
import com.bancosantander.testmobdevbryan.domain.model.BreedsImg


class BreedsRepository(
    private val remoteDataSource: BreedsRemoteDataSource
) {
    suspend fun getBreeds():Breeds{
        return  remoteDataSource.getBreeds().toBreeds()
    }
    suspend fun getBreedsImg(name:String):BreedsImg {
        return remoteDataSource.getBreedsImg(name).toBreedsImg()
    }
}