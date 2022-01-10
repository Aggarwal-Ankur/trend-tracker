package com.dataworks.trendtracker.toptrends

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dataworks.trendtracker.databinding.ListItemTrendingBinding

class TopTrendsAdapter : ListAdapter<TrendingData, TopTrendsVH>(TopTrendsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopTrendsVH {
        return TopTrendsVH.from(parent)
    }

    override fun onBindViewHolder(holder: TopTrendsVH, position: Int) {
        val item = getItem(position)

        holder.bind(item)
    }

}

class TopTrendsVH private constructor(val binding : ListItemTrendingBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TrendingData) {
        binding.trend = item
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): TopTrendsVH {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemTrendingBinding.inflate(layoutInflater, parent, false)
            return TopTrendsVH(binding)
        }
    }
}

class TopTrendsDiffCallback : DiffUtil.ItemCallback<TrendingData>() {
    override fun areItemsTheSame(oldItem: TrendingData, newItem: TrendingData): Boolean {
        return oldItem.hashtag == newItem.hashtag
    }

    override fun areContentsTheSame(oldItem: TrendingData, newItem: TrendingData): Boolean {
        return oldItem == newItem
    }
}