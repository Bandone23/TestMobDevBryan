package com.bancosantander.testmobdevbryan.presentation.base

import android.content.Intent
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule

import org.junit.Rule
import org.junit.Test

@LargeTest
class MainActivityTest {
    @Rule
    @JvmField
    var rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun setUp(){
        val intent = Intent()
        rule.launchActivity(intent)

    }
}