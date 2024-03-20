package com.example.android4_1.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android4_1.data.remote.apiservises.models.Data
import com.example.android4_1.databinding.ItemBinding

class AnimeAdapter : PagingDataAdapter<Data, AnimeAdapter.AnimeViewholder>(DiffUtilCallback()) {
    inner class AnimeViewholder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(mangaModule: Data) {
            Glide.with(binding.rvItem.context).load(
                mangaModule.attributes.posterImage.medium
            ).into(binding.rvItem)
            binding.textItem.text = mangaModule.attributes.titles.enJp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewholder {
        return AnimeViewholder(
            ItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeViewholder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Data>() {

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}
