package ar.com.wolox.android.example.ui.home;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {

    @ContributesAndroidInjector
    protected abstract HomeActivity homeActivity();

    @ContributesAndroidInjector
    protected abstract HomeFragment homeFragment();

}
