package ar.com.wolox.android.example.ui.home

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeModule {

    @ContributesAndroidInjector
    protected abstract fun homeActivity(): HomeActivity

    @ContributesAndroidInjector
    protected abstract fun homeFragment(): HomeFragment
}
