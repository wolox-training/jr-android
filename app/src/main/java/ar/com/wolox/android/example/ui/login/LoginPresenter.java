package ar.com.wolox.android.example.ui.login;

import android.util.Patterns;

import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import ar.com.wolox.android.example.model.User;
import ar.com.wolox.android.example.service.UserAuthService;
import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter extends BasePresenter<LoginView> {
    private static final String URL = "http://www.wolox.com.ar";

    private UserSession userSession;
    private RetrofitServices retrofitService;

    @Inject
    public LoginPresenter(UserSession userSession, RetrofitServices retrofitService) {
        this.userSession = userSession;
        this.retrofitService = retrofitService;
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
            authenticate(email, password);
        } else {
            for (ErrorCase error : errors) {
                error.callAction(getView());
            }
        }
    }

    private List<ErrorCase> getErrors(String email, String password) {
        List<ErrorCase> errors = new ArrayList<>();

        boolean emailIsEmpty = Strings.isNullOrEmpty(email);
        boolean passwordIsEmpty = Strings.isNullOrEmpty(password);
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

    private void authenticate(String email, String password) {
        UserAuthService userAuthService = retrofitService.getService(UserAuthService.class);
        userAuthService.findUserByEmailAndPassword(email).enqueue(getCallback(email, password));
    }

    private Callback<List<User>> getCallback(String email, String password) {
        return new Callback<List<User>>() {
            @Override
            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                List<User> users = response.body();
                if (users != null && !users.isEmpty() && users.get(0).getPassword().equals(password)) {
                    userSession.setUsername(email);
                    getView().goToHomePage();
                } else {
                    getView().invalidateLogin();
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable t) {
                getView().invalidateLogin();
            }
        };
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
