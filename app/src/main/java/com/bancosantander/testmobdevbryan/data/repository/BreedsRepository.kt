package com.bancosantander.testmobdevbryan.data.repository


import com.bancosantander.testmobdevbryan.data.remote.model.toBreeds
import com.bancosantander.testmobdevbryan.data.remote.model.toBreedsImg
import com.bancosantander.testmobdevbryan.data.remote.source.BreedsRemoteDataSource
import com.bancosantander.testmobdevbryan.domain.model.Breeds
import com.bancosantander.testmobdevbryan.domain.model.BreedsImg


open class BreedsRepository(
   // private val remoteDataSource: BreedsRemoteDataSource
private val factory: BreedsRepositoryFactory
):BreedsRepositoryIntrf {
    override suspend fun getBreeds(): Breeds {
      return factory.getRemoteDataSource().getBreeds().toBreeds()
    }

    override suspend fun getBreedsImg(name: String): BreedsImg {
        return factory.getRemoteDataSource().getBreedsImg(name).toBreedsImg()
    }

}