package ar.com.wolox.android.example.ui.login;

import javax.inject.Inject;

import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 *  Login presenter class 
 */
public class LoginPresenter extends BasePresenter<LoginView> {
    private static final String URL = "http://www.wolox.com.ar";
    private static final String REGEX_EMAIL = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";

    private UserSession userSession;

    @Inject
    public LoginPresenter(UserSession userSession) {
        this.userSession = userSession;
    }

    public void onTermsAndConditionsClicked() {
        this.getView().openBrowser(URL);
    }

    public void onSignupClicked() {
        this.getView().goToSignupView();
    }

    public void onLoginClicked(String email, String password) {
        if (!fieldsAreEmpty(email, password) && !emailIsInvalid(email)) {
            userSession.setUsername(email);
            this.getView().goToHomePage();
        }
    }

    private boolean fieldsAreEmpty(String email, String password) {
        boolean emailIsEmpty = "".equals(email);
        if (emailIsEmpty) {
            this.getView().invalidateEmail("The email cannot be empty.");
        }

        boolean passwordIsEmpty = "".equals(password);
        if (passwordIsEmpty) {
            this.getView().invalidatePassword("The password cannot be empty.");
        }

        return emailIsEmpty || passwordIsEmpty;
    }

    private boolean emailIsInvalid(String email) {
        boolean emailIsInvalid = !email.matches(REGEX_EMAIL);
        if (emailIsInvalid) {
            this.getView().invalidateEmail("The email does not have the correct format.");
        }

        return emailIsInvalid;
    }

}
