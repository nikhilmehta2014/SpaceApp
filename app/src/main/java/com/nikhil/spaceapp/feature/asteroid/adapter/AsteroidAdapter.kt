package com.nikhil.spaceapp.feature.asteroid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nikhil.spaceapp.databinding.ItemAsteroidBinding
import com.nikhil.spaceapp.feature.asteroid.dto.Asteroid

class AsteroidAdapter(private val items: List<Asteroid>, private val callback: (Asteroid) -> Unit) :
    RecyclerView.Adapter<AsteroidAdapter.AsteroidViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {
        return AsteroidViewHolder(
            ItemAsteroidBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        holder.bind(items[position], callback)
    }

    override fun getItemCount() = items.size

    inner class AsteroidViewHolder(private val binding: ItemAsteroidBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            asteroid: Asteroid,
            callback: (Asteroid) -> Unit
        ) {
            binding.asteroid = asteroid
            itemView.setOnClickListener {
                callback(asteroid)
            }
        }
    }
}