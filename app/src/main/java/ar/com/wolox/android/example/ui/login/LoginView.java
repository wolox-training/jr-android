package ar.com.wolox.android.example.ui.login;

interface LoginView {

    void openBrowser(String url);

    void goToSignupView();

    void goToHomePage();

    void invalidateEmail(String text);

    void invalidatePassword(String text);

    void saveLogin(String email, String password);

}
