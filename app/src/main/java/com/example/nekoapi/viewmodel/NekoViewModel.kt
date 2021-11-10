package com.example.nekoapi.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.nekoapi.model.Categories
import com.example.nekoapi.model.Gifs
import com.example.nekoapi.model.Images
import com.example.nekoapi.repo.NekoRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NekoViewModel : ViewModel() {

    private val _categories = MutableLiveData<Categories>()
    val categories: LiveData<Categories> get() = _categories

    private val _gifs = MutableLiveData<Gifs>()
    val gifs: LiveData<Gifs> get() = _gifs

    private val _images = MutableLiveData<Images>()
    val images: LiveData<Images> get() = _images

    private val _fullscreenImage = MutableLiveData<String>()
    val fullscreenImage: LiveData<String> get() = _fullscreenImage

    fun getCategories() {

        viewModelScope.launch(Dispatchers.IO) {

            val response = NekoRepo.getCategories()

            response?.let { categories -> _categories.postValue(categories) }

            if (response == null)
                nullDebugLog("Categories")

        }

    }

    fun getGifs(category: String, amount: Int) {

        viewModelScope.launch(Dispatchers.IO) {

            val response = NekoRepo.getGifs(category, amount)

            response?.let { gifs -> _gifs.postValue(gifs) }

            if (response == null)
                nullDebugLog("Gifs")

        }

    }

    fun getImages(category: String, amount: Int) {

        viewModelScope.launch(Dispatchers.IO) {

            val response = NekoRepo.getImages(category, amount)

            response?.let { images -> _images.postValue(images) }

            if (response == null)
                nullDebugLog("Images")

        }

    }

    fun setFullscreenImage(url: String) {

        _fullscreenImage.postValue(url)

        Log.d("DEBUG_INFO", "Fullscreen image set to $url")

    }

    private fun nullDebugLog(name: String) = Log.d("DEBUG_INFO", "$name are null")

}