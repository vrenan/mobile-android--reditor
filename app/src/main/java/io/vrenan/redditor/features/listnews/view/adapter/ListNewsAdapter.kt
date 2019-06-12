package io.vrenan.redditor.features.listnews.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.vrenan.redditor.R
import io.vrenan.redditor.features.listnews.model.News
import io.vrenan.redditor.features.listnews.view.viewholders.ItemNewsViewHolder

class ListNewsAdapter(): RecyclerView.Adapter<ItemNewsViewHolder>() {
    private var items: List<News> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemNewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ItemNewsViewHolder(view)
    }

    fun update( items: List<News>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holderNews: ItemNewsViewHolder, position: Int) {
        holderNews.bindNews(items[position])
    }

}