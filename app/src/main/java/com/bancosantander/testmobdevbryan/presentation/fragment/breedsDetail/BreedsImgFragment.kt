package com.bancosantander.testmobdevbryan.presentation.fragment.breedsDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bancosantander.core.coroutines.Result
import com.bancosantander.core.extension.observe
import com.bancosantander.testmobdevbryan.databinding.FragmentBreedsImgBinding
import com.bancosantander.testmobdevbryan.domain.model.BreedsImg
import com.bancosantander.testmobdevbryan.presentation.adapter.BreedImgAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreedsImgFragment : Fragment() {
    private val viewModel: BreedsImgViewModel by viewModel()
    lateinit var binding: FragmentBreedsImgBinding

    private val breedsImg: ArrayList<String> = ArrayList()
    private lateinit var mBreedsImgAdapter: BreedImgAdapter

    private var nameBreeds: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nameBreeds = BreedsImgFragmentArgs.fromBundle(requireArguments()).nameBreeds
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedsImgBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        with(viewModel) {
            observe(breedImgLiveData, ::breedsImgRemoteObserver)
        }

        viewModel.getBreedsImg(nameBreeds)

        return binding.root
    }

    private fun breedsImgRemoteObserver(result: Result<BreedsImg>?) {
        when (result) {
            is Result.OnLoading -> {
                binding.rvAnimalImgList.visibility = View.GONE
                binding.progressCircularImg.visibility = View.VISIBLE
            }
            is Result.OnSuccess -> {

                binding.progressCircularImg.visibility = View.GONE
                binding.rvAnimalImgList.visibility = View.VISIBLE

                if (result.value.message.isNotEmpty()) {
                    breedsImg.clear()
                    for (item in result.value.message.indices) {
                        breedsImg.add(result.value.message[item])
                    }
                    mBreedsImgAdapter = BreedImgAdapter(breedsImg)
                    binding.rvAnimalImgList.layoutManager = LinearLayoutManager(context)
                    binding.rvAnimalImgList.adapter = mBreedsImgAdapter
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

}