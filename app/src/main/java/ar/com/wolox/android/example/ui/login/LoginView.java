package ar.com.wolox.android.example.ui.login;

public interface LoginView {

    void openBrowser(String url);

    void goToSignupView();

    void goToHomePage();

    void invalidateEmptyEmail();

    void invalidateEmailFormat();

    void invalidateEmptyPassword();

    void invalidateLogin();

    void invalidateConnection();

    void showLoading();

    void stopLoading();

}
