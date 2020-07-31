package com.bancosantander.testmobdevbryan.data.remote.net

import com.bancosantander.testmobdevbryan.data.remote.model.BreedsEntry
import retrofit2.Call
import retrofit2.http.GET

interface BreedsApi {
    @GET("breeds/list")
    fun getBreeds(): Call<BreedsEntry>
}