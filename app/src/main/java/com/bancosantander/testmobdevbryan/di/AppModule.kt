package com.bancosantander.testmobdevbryan.di

import android.content.Context
import android.net.ConnectivityManager
import com.bancosantander.testmobdevbryan.URL_BASE_API
import com.bancosantander.testmobdevbryan.data.remote.net.BreedsApi
import com.bancosantander.testmobdevbryan.data.remote.source.BreedsRemoteDataSource
import com.bancosantander.testmobdevbryan.data.repository.BreedsRepository
import com.bancosantander.testmobdevbryan.data.repository.BreedsRepositoryFactory
import com.bancosantander.testmobdevbryan.data.repository.BreedsRepositoryIntrf
import com.bancosantander.testmobdevbryan.domain.usecase.GetBreedsImgRemoteUseCase
import com.bancosantander.testmobdevbryan.domain.usecase.GetBreedsRemoteUseCase
import com.bancosantander.testmobdevbryan.presentation.fragment.breeds.BreedsViewModel
import com.bancosantander.testmobdevbryan.presentation.fragment.breedsDetail.BreedsImgViewModel
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.experimental.builder.factory
import org.koin.experimental.builder.factoryBy
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    /* Android Services */
    single {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
    /* Retrofit */
    single {
        OkHttpClient.Builder()
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(URL_BASE_API)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(BreedsApi::class.java) as BreedsApi }

    /* View models */
    viewModel<BreedsViewModel>()
    viewModel<BreedsImgViewModel>()
    /* Repository */
    factoryBy<BreedsRepositoryIntrf, BreedsRepository>()

    /* DataSource */
    factory<BreedsRemoteDataSource>()
    /* factory */
    factory<BreedsRepositoryFactory>()
    /* UseCase */
    factory<GetBreedsRemoteUseCase>()
    factory<GetBreedsImgRemoteUseCase>()



    single { Picasso.get() }
}


