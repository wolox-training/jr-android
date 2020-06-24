package ar.com.wolox.android.example.ui.news

import ar.com.wolox.android.example.model.NewsArticle

interface NewsView {

    fun loadNews(newsList: List<NewsArticle>)

    fun showConnectionError()

    fun stopLoading()
}
