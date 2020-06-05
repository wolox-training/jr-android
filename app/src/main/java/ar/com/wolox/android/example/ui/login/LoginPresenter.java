package ar.com.wolox.android.example.ui.login;

import android.util.Patterns;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import kotlin.text.StringsKt;

public class LoginPresenter extends BasePresenter<LoginView> {
    private static final String URL = "http://www.wolox.com.ar";

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

    public void onLoginClicked(@NonNull String email, @NonNull String password) {
        List<ErrorCase> errors = getErrors(email, password);
        if (errors.isEmpty()) {
            userSession.setUsername(email);
            this.getView().goToHomePage();
        } else {
            for (ErrorCase error : errors) {
                error.callAction(getView());
            }
        }
    }

    private List<ErrorCase> getErrors(String email, String password) {
        List<ErrorCase> errors = new ArrayList<>();

        boolean emailIsEmpty = StringsKt.isBlank(email);
        boolean passwordIsEmpty = StringsKt.isBlank(password);
        boolean emailIsInvalid = !Patterns.EMAIL_ADDRESS.matcher(email).matches();

        if (emailIsEmpty) {
            errors.add(ErrorCase.EMPTY_EMAIL);
        } else if (emailIsInvalid) {
            errors.add(ErrorCase.INVALID_EMAIL);
        }
        if (passwordIsEmpty) {
            errors.add(ErrorCase.EMPTY_PASSWORD);
        }

        return errors;
    }

    private enum ErrorCase {
        EMPTY_EMAIL {
            public void callAction(LoginView view) {
                view.invalidateEmptyEmail();
            }
        },
        EMPTY_PASSWORD {
            public void callAction(LoginView view) {
                view.invalidateEmptyPassword();
            }
        },
        INVALID_EMAIL {
            public void callAction(LoginView view) {
                view.invalidateEmailFormat();
            }
        };

        public abstract void callAction(LoginView view);
    }
}
