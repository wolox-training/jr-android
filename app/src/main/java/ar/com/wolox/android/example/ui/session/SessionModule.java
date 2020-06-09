package ar.com.wolox.android.example.ui.session;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SessionModule {

    @ContributesAndroidInjector
    protected abstract SessionActivity sessionActivity();

}
