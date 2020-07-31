package com.bancosantander.testmobdevbryan.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bancosantander.core.extension.observe
import com.bancosantander.testmobdevbryan.R
import com.bancosantander.testmobdevbryan.data.remote.model.BreedsEntry
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.bancosantander.core.coroutines.Result
import com.bancosantander.testmobdevbryan.presentation.adapter.BreedAdapter
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val viewModel: BreedsViewModel by viewModel()
    private val breeds: ArrayList<String> = ArrayList()
    lateinit var mBreedsAdapter: BreedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        with(viewModel) {
            observe(breedsLiveData, ::breedsObserver)
        }
        viewModel.getBreeds()


    }

    private fun breedsObserver(result: Result<BreedsEntry>?) {
        when (result) {
            is Result.OnLoading -> {
                progress_circular_img.visibility = View.VISIBLE
            }
            is Result.OnSuccess -> {
                progress_circular_img.visibility = View.GONE
                rv_animal_list.visibility = View.VISIBLE
                if (result.value.message.isNotEmpty()) {
                    for (item in result.value.message.indices) {
                        breeds.add(result.value.message[item])
                    }
                    mBreedsAdapter = BreedAdapter(breeds) { animals, viewId: Int -> breedsClicked(animals, viewId) }
                    rv_animal_list.layoutManager = LinearLayoutManager(this)
                    rv_animal_list.adapter = mBreedsAdapter
                } else { Toast.makeText(this,"no hay datos",Toast.LENGTH_SHORT).show() }
            }

            is Result.OnError -> { }
            else -> { }
        }
    }

    private fun breedsClicked(breeds:String, viewId: Int) {
        when (viewId) {
            R.id.container_card -> {
               Toast.makeText(this, "raza:$breeds",Toast.LENGTH_SHORT).show()
            }
        }
    }
}