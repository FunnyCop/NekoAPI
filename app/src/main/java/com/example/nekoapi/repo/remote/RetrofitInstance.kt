package com.example.nekoapi.repo.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

/** Object that holds an instance of retrofit and instances of services */
object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://nekos.best/api/v1/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val nekoService = retrofit.create<NekoService>()

}