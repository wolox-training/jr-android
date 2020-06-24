package ar.com.wolox.android.example.ui.news

import ar.com.wolox.android.example.model.NewsArticle
import ar.com.wolox.android.example.service.NewsService
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewsPresenter @Inject constructor(val retrofitServices: RetrofitServices) : BasePresenter<NewsView>() {

    fun searchForNews() {
        val newsService: NewsService = retrofitServices.getService(NewsService::class.java)
        newsService.getNews(page, "createdAt", "desc").enqueue(getCallback())
        view!!.stopLoading()
    }

    private fun getCallback(): Callback<MutableList<NewsArticle>> {
        return object : Callback<MutableList<NewsArticle>> {
            override fun onFailure(call: Call<MutableList<NewsArticle>>, t: Throwable) =
                    showError()
            override fun onResponse(call: Call<MutableList<NewsArticle>>, response: Response<MutableList<NewsArticle>>) =
                    view!!.loadNews(response.body() ?: emptyList())
        }
    }

    private fun showError() = view!!.showConnectionError()

    companion object {
        val page = 0
    }
}
