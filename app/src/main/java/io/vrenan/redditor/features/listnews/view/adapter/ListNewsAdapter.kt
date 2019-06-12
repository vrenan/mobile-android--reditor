package io.vrenan.redditor.features.listnews.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.vrenan.redditor.R
import io.vrenan.redditor.features.listnews.model.News
import io.vrenan.redditor.features.listnews.view.viewholders.NewsItemViewHolder

class ListNewsAdapter(val items: Array<News>): RecyclerView.Adapter<NewsItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bindNews(items[position])
    }

}