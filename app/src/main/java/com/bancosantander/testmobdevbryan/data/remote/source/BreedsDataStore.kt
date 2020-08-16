package com.bancosantander.testmobdevbryan.data.remote.source

import com.bancosantander.testmobdevbryan.data.remote.model.BreedsEntry
import com.bancosantander.testmobdevbryan.data.remote.model.BreedsImgEntry

interface BreedsDataStore {
    suspend fun getBreeds():BreedsEntry
    suspend fun getBreedsImg(name:String): BreedsImgEntry
}