package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment private constructor() : WolmoFragment<HomePresenter>(), HomeView {

    override fun init() {
    }

    override fun layout(): Int {
        return R.layout.fragment_home
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun setListeners() {
        vTabNews?.setOnClickListener { presenter.onNewsSelected() }
        vTabProfile?.setOnClickListener { presenter.onProfileSelected() }
    }

    override fun onNewsSelected() {
        // vTabNews.icon.draw(resources.getDrawable(R.drawable.ic_news_list_on))
    }

    override fun onProfileSelected() {
        TODO("Not yet implemented")
    }
}