package ar.com.wolox.android.example.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.TextView;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.android.example.ui.signup.SignupActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 *  Login fragment class
 */
public final class LoginFragment extends WolmoFragment<LoginPresenter> implements LoginView {

    private static LoginFragment instance;

    private LoginFragment() {
    }

    public static LoginFragment newInstance() {
        if (instance == null) {
            instance = new LoginFragment();
        }
        return instance;
    }

    @Override
    public void init() {
    }

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void setListeners() {
        getView().findViewById(R.id.vLoginTermsAndConditionsText)
                .setOnClickListener(it -> getPresenter().onTermsAndConditionsClicked());
        getView().findViewById(R.id.vLoginLoginButton)
                .setOnClickListener(it -> getPresenter()
                        .onLoginClicked(((TextView) getView().findViewById(R.id.vLoginEmailField)).getText().toString(),
                                        ((TextView) getView().findViewById(R.id.vLoginPasswordField)).getText().toString()));
        getView().findViewById(R.id.vLoginSignupButton)
                .setOnClickListener(it -> getPresenter().onSignupClicked());
    }

    @Override
    public void openBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void goToHomePage() {
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void saveLogin(String email, String password) {
        SharedPreferences.Editor editor = getActivity()
                .getPreferences(Context.MODE_PRIVATE)
                .edit();
        editor.putString("preference_login_email", email);
        editor.putString("preference_login_password", password);
        editor.apply();
    }

    @Override
    public void invalidateEmail(String text) {
        ((TextView) getView().findViewById(R.id.vLoginEmailField)).setError(text);
    }

    @Override
    public void invalidatePassword(String text) {
        ((TextView) getView().findViewById(R.id.vLoginPasswordField)).setError(text);
    }

    @Override
    public void goToSignupView() {
        Intent intent = new Intent(getActivity(), SignupActivity.class);
        startActivity(intent);
    }

}
