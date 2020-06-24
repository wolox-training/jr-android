package ar.com.wolox.android.example.ui.news

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.NewsArticle
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<NewsPresenter>(), NewsView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun layout(): Int = R.layout.fragment_news

    override fun init() {
        viewManager = LinearLayoutManager(activity)
        presenter.searchForNews()
    }

    override fun setListeners() {
        vNewsRefresh.setOnRefreshListener { presenter.searchForNews() }
    }

    override fun loadNews(list: List<NewsArticle>) {
        viewAdapter = NewsListAdapter(list, activity!!)
        recyclerView = vListNews.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun showConnectionError() {
        val toast: Toast = Toast.makeText(context, R.string.error_connection, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun stopLoading() {
        vNewsRefresh.isRefreshing = false
    }
}
