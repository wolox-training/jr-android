package ar.com.wolox.android.example.ui.home

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.NewsArticle
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.news_tab.vListNews

class HomeFragment private constructor() : WolmoFragment<HomePresenter>(), HomeView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun init() {
        viewManager = LinearLayoutManager(activity)
        viewAdapter = NewsListAdapter(listOf(NewsArticle("test", "test", "test", false)), activity!!)

        recyclerView = vListNews.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun layout() = R.layout.fragment_home

    companion object {
        fun newInstance() = HomeFragment()
    }
}
