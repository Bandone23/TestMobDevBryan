package com.bancosantander.testmobdevbryan

import com.bancosantander.testmobdevbryan.data.remote.net.BreedsApi
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.junit.Assert.assertNotNull
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class BreedsApiTest : KoinTest {

    private val nameBreeds = "akita"

    private val api : BreedsApi by inject()

    @Before
    fun `start koin`() {
        startKoin {
            modules(listOf(testModule))
        }
    }

    @Test
    fun `should get Breeds from  api`() {
       val result = kotlin.runCatching {
           api.getBreeds().isExecuted
       }
    }
    @Test
    fun `should get BreedsImg from  api`() {
        val result = kotlin.runCatching {
            api.getBreedsImg(name = nameBreeds).isExecuted
        }
    }

    @After
    fun `stop koin`() {
        stopKoin()
    }
}