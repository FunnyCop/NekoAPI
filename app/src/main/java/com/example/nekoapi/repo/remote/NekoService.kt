package com.example.nekoapi.repo.remote

import com.example.nekoapi.model.Categories
import com.example.nekoapi.model.Gifs
import com.example.nekoapi.model.Images
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/** Interface that defines retrofit queries */
interface NekoService {

    @GET("endpoints") suspend fun getCategories(): Response<Categories>

    @GET("{category}") suspend fun getGifs(

        @Path("category") category: String,
        @Query("amount") amount: Int

    ): Response<Gifs>

    @GET("{category}") suspend fun getImages(

        @Path("category") category: String,
        @Query("amount") amount: Int

    ): Response<Images>

}