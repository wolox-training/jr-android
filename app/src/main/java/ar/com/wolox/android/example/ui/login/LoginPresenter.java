package ar.com.wolox.android.example.ui.login;

import javax.inject.Inject;

import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 *
 */
public class LoginPresenter extends BasePresenter<LoginView> {
    private static final String URL = "http://www.wolox.com.ar";

    @Inject
    public LoginPresenter() {

    }

    public void onTermsAndConditionsClicked() {
        this.getView().openBrowser(URL);
    }

    public void onSignupClicked() {
        this.getView().goToSignupView();
    }

    public void onLoginClicked() {
        this.getView().goToHomePage();
    }

}
