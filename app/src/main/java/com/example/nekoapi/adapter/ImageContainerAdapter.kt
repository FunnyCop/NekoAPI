package com.example.nekoapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nekoapi.databinding.ImageContainerItemBinding

class ImageContainerAdapter(

    private val onItemClick: (url: String) -> Unit

) : RecyclerView.Adapter<ImageContainerAdapter.ImageContainerViewHolder>() {

    private val urls = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageContainerViewHolder = ImageContainerViewHolder.getInstance(parent)

    override fun onBindViewHolder(holder: ImageContainerViewHolder, position: Int) {

        holder.itemView.setOnClickListener { onItemClick(urls[position]) }

        holder.loadUrl(urls[position])

    }

    override fun getItemCount(): Int = urls.size

    fun updateUrls(urls: List<String>) {

        val size = this.urls.size
        this.urls.clear()
        notifyItemRangeRemoved(0, size)

        this.urls.addAll(urls)
        notifyItemRangeInserted(0, urls.size)

    }

    class ImageContainerViewHolder(

        private val binding: ImageContainerItemBinding

    ) : RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun getInstance(parent: ViewGroup): ImageContainerViewHolder = ImageContainerViewHolder(

                ImageContainerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            )

        }

        fun loadUrl(url: String) = with(binding) {

            Glide.with(binding.root).load(url).into(sivMain)

        }

    }

}