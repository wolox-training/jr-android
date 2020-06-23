package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.example.ui.news.NewsFragment
import ar.com.wolox.android.example.ui.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeModule {

    @ContributesAndroidInjector
    protected abstract fun homeActivity(): HomeActivity

    @ContributesAndroidInjector
    protected abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector
    protected abstract fun newsFragment(): NewsFragment

    @ContributesAndroidInjector
    protected abstract fun profileFragment(): ProfileFragment
}
