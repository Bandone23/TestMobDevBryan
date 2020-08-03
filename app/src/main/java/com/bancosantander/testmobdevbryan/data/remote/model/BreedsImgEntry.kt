package com.bancosantander.testmobdevbryan.data.remote.model

import com.bancosantander.testmobdevbryan.domain.model.BreedsImg

data class BreedsImgEntry(
    val message:List<String>,
    val status :String
)
fun BreedsImgEntry.toBreedsImg()=BreedsImg (
    message=message,
    status = status
)