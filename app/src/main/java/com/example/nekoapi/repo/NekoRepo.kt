package com.example.nekoapi.repo

import com.example.nekoapi.model.Categories
import com.example.nekoapi.model.Gifs
import com.example.nekoapi.model.Images
import com.example.nekoapi.repo.remote.RetrofitInstance

/** Object that defines how retrofit queries should behave */
object NekoRepo {

    private val nekoService by lazy { RetrofitInstance.nekoService }

    suspend fun getCategories(): Categories? {

        val response = nekoService.getCategories()

        return if (response.isSuccessful) response.body() else null

    }

    suspend fun getGifs(category: String, amount: Int): Gifs? {

        val response = if (amount > 20) nekoService.getGifs(category, 20)
            else nekoService.getGifs(category, amount)

        return if (response.isSuccessful) response.body() else null

    }

    suspend fun getImages(category: String, amount: Int): Images? {

        val response = if (amount > 20) nekoService.getImages(category, 20)
            else nekoService.getImages(category, amount)

        return if (response.isSuccessful) response.body() else null

    }

}