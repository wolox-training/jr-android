package ar.com.wolox.android.example.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.NewsArticle

class NewsListAdapter constructor(val data: List<NewsArticle>, val context: Context) : RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            NewsViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.news_row, parent, false))

    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
    }
}
