package ar.com.wolox.android.example.ui.login;

interface LoginView {

    void openBrowser(String url);

    void goToSignupView();

    void goToHomePage();

    void invalidateEmptyEmail();

    void invalidateEmailFormat();

    void invalidateEmptyPassword();

}
