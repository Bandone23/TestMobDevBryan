package com.bancosantander.testmobdevbryan.presentation.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bancosantander.core.extension.observe
import com.bancosantander.testmobdevbryan.R
import com.bancosantander.testmobdevbryan.data.remote.model.BreedsEntry
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.bancosantander.core.coroutines.Result
import com.bancosantander.testmobdevbryan.presentation.fragment.breeds.BreedsViewModel
import com.bancosantander.testmobdevbryan.presentation.adapter.BreedAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}