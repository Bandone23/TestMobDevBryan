package com.bancosantander.testmobdevbryan.data.repository

import com.bancosantander.testmobdevbryan.domain.model.Breeds
import com.bancosantander.testmobdevbryan.domain.model.BreedsImg

interface BreedsRepositoryIntrf {
    suspend fun getBreeds(): Breeds
    suspend fun getBreedsImg(name:String): BreedsImg
}