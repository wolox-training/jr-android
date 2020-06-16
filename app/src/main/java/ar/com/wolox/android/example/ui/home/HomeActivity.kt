package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.home.HomeFragment.Companion.newInstance
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class HomeActivity : WolmoActivity() {
    override fun layout() = R.layout.activity_base

    override fun init() = replaceFragment(R.id.vActivityBaseContent, newInstance())
}
