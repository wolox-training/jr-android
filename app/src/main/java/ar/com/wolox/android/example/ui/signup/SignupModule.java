package ar.com.wolox.android.example.ui.signup;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SignupModule {

    @ContributesAndroidInjector
    protected abstract SignupActivity signupActivity();

    @ContributesAndroidInjector
    protected abstract SignupFragment signupFragment();

}
