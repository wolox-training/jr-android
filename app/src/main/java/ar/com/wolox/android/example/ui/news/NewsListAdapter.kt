package ar.com.wolox.android.example.ui.news

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.NewsArticle
import kotlinx.android.synthetic.main.news_row.view.*

class NewsListAdapter constructor(val data: List<NewsArticle>, val context: Context) : RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.vNewsTitle
        val text = itemView.vNewsContent
        val createdAt = itemView.vDate
        val picture = itemView.vNewsPhoto
        val likes = itemView.vLikeIcon
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.news_row, parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.text.text = data[position].text
        holder.createdAt.text = data[position].createdAt
        holder.picture.setImageURI(data[position].picture.httpToHttps())
        holder.likes.isChecked = data[position].likes.size > 0

        truncateContent(holder)
    }

    private fun String.httpToHttps() = this.apply {
        return replace("http", "https")
    }

    private fun truncateContent(holder: NewsViewHolder) {
        holder.text.maxLines = 3
        holder.text.ellipsize = TextUtils.TruncateAt.END
    }
}
