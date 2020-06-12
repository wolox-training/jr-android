package ar.com.wolox.android.example.ui.home

import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class HomePresenter @Inject constructor() : BasePresenter<HomeView?>() {

    fun onNewsSelected() {
        view?.onNewsSelected()
    }

    fun onProfileSelected() {
        view?.onProfileSelected()
    }
}