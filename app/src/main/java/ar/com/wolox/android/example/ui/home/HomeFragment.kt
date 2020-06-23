package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.news.NewsFragment
import ar.com.wolox.android.example.ui.profile.ProfileFragment
import ar.com.wolox.wolmo.core.adapter.viewpager.SimpleFragmentPagerAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment private constructor() : WolmoFragment<HomePresenter>(), HomeView {

    @Inject
    lateinit var newsFragment: NewsFragment

    @Inject
    lateinit var profileFragment: ProfileFragment

    override fun init() {
        val fragmentPagerAdapter = SimpleFragmentPagerAdapter(childFragmentManager)
        fragmentPagerAdapter.addFragments(
                Pair(newsFragment, getString(R.string.home_news)),
                Pair(profileFragment, getString(R.string.home_profile))
        )
        vContent.adapter = fragmentPagerAdapter
        vTabLayout.setupWithViewPager(vContent)
    }

    override fun layout() = R.layout.fragment_home

    companion object {
        fun newInstance() = HomeFragment()
    }
}
