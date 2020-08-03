package com.bancosantander.testmobdevbryan.data.remote.model

import com.bancosantander.testmobdevbryan.domain.model.Breeds

data class BreedsEntry(
    val message: List<String>,
    val status: String
)

fun BreedsEntry.toBreeds() = Breeds(
    message = message,
    status = status
)