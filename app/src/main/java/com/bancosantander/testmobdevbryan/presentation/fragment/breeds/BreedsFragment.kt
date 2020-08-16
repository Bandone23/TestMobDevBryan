package com.bancosantander.testmobdevbryan.presentation.fragment.breeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bancosantander.core.coroutines.Result
import com.bancosantander.core.extension.observe
import com.bancosantander.testmobdevbryan.R
import com.bancosantander.testmobdevbryan.databinding.FragmentBreedsBinding
import com.bancosantander.testmobdevbryan.domain.model.Breeds
import com.bancosantander.testmobdevbryan.presentation.adapter.BreedAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

open class BreedsFragment : Fragment() {
    private val viewModel: BreedsViewModel by viewModel()
    private lateinit var binding: FragmentBreedsBinding
    private val breeds: ArrayList<String> = ArrayList()
    private lateinit var mBreedsAdapter: BreedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        with(viewModel) {
            observe(breedsLiveData, ::breedsObserver)
        }
        viewModel.getBreeds()

    }

    private fun breedsObserver(result: Result<Breeds>?) {
        when (result) {
            is Result.OnLoading -> {
                binding.rvAnimalList.visibility = View.GONE
                binding.progressCircularImg.visibility = View.VISIBLE
            }
            is Result.OnSuccess -> {

                binding.progressCircularImg.visibility = View.GONE
                binding.rvAnimalList.visibility = View.VISIBLE

                if (result.value.message.isNotEmpty()) {
                    breeds.clear()
                    for (item in result.value.message.indices) {
                        breeds.add(result.value.message[item])
                    }
                    mBreedsAdapter = BreedAdapter(breeds) { animals, viewId: Int ->
                        breedsClicked(
                            animals,
                            viewId
                        )
                    }
                    binding.rvAnimalList.layoutManager = LinearLayoutManager(context)
                    binding.rvAnimalList.adapter = mBreedsAdapter
                } else {
                    Toast.makeText(context, "no hay datos", Toast.LENGTH_SHORT).show()
                }
            }
            is Result.OnError -> {
            }
            else -> {
            }
        }
    }

    private fun breedsClicked(breeds: String, viewId: Int) {
        when (viewId) {
            R.id.container_card -> {
                val action = BreedsFragmentDirections.nextBreeds(breeds)
                findNavController().navigate(action)
            }
        }
    }
}