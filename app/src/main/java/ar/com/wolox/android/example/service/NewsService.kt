package ar.com.wolox.android.example.service

import ar.com.wolox.android.example.model.NewsArticle
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("news")
    fun getNews(
        @Query("_page") page: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Call<MutableList<NewsArticle>>
}
