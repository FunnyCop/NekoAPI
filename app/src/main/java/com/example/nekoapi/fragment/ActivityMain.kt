package com.example.nekoapi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.nekoapi.R
import com.example.nekoapi.adapter.ImageContainerAdapter
import com.example.nekoapi.databinding.ActivityMainBinding
import com.example.nekoapi.model.Categories
import com.example.nekoapi.viewmodel.NekoViewModel

class ActivityMain : Fragment() {

    private var _binding: ActivityMainBinding? = null
    private val  binding get() = _binding!!
    private val viewModel by activityViewModels<NekoViewModel>()

    private var category = ""

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View = ActivityMainBinding.inflate(layoutInflater, container, false)
        .also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        initAdapters()
        initListeners()
        initObservers()

    }

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null

    }

    private fun initAdapters() {

        (binding.mactvCategoryDropdown as AutoCompleteTextView).setAdapter(ArrayAdapter(requireContext(), R.layout.dropdown_item, Categories.namesArray))

        binding.rvImageContainer.adapter = ImageContainerAdapter() {

            viewModel.setFullscreenImage(it)

            binding.sivFullscreen.visibility = View.VISIBLE

        }

    }

    private  fun initListeners() {

        binding.mactvCategoryDropdown.setOnItemClickListener { _, view, _, _ -> category = (view as TextView).text.toString() }

        binding.mbtnEnter.setOnClickListener { if (category != "") viewModel.getCategories() }

        binding.sivFullscreen.setOnClickListener { it.visibility = View.GONE }

    }

    private fun initObservers() {

        viewModel.categories.observe(viewLifecycleOwner) {

            if (category != "" && it != null) {

                val max = it[category].max.toInt()

                if (category != "nekos") viewModel.getGifs(category, max)
                else viewModel.getImages(category, max)

            }

        }

        viewModel.gifs.observe(viewLifecycleOwner) {

            if (it != null) {

                val gifs = mutableListOf<String>()

                for (gif in it.url)
                    gifs.add(gif.url)

                (binding.rvImageContainer.adapter as ImageContainerAdapter).updateUrls(gifs)

            }

        }

        viewModel.images.observe(viewLifecycleOwner) {

            if (it != null) {

                val images = mutableListOf<String>()

                for (image in it.url)
                    images.add(image.url)

                (binding.rvImageContainer.adapter as ImageContainerAdapter).updateUrls(images)

            }

        }

        viewModel.fullscreenImage.observe(viewLifecycleOwner) {

            Glide.with(binding.sivFullscreen).load(it).into(binding.sivFullscreen)

        }

    }

}