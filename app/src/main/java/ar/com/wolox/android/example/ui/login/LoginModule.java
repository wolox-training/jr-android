package ar.com.wolox.android.example.ui.login;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginModule {

    @ContributesAndroidInjector
    protected abstract LoginActivity loginActivity();

    @ContributesAndroidInjector
    protected abstract LoginFragment loginFragment();

}
