package ar.com.wolox.android.example.service

import ar.com.wolox.android.example.model.NewsArticle
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {

    @GET("news")
    fun getNews(): Call<MutableList<NewsArticle>>
}
