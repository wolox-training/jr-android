package ar.com.wolox.android.example.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.WindowManager;
import android.widget.Button;
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

    // Components
    private TextView emailField;
    private TextView passwordField;
    private Button loginButton;
    private Button signupButton;
    private TextView termsAndConditions;

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
        requireActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        emailField = getView().findViewById(R.id.vLoginEmailField);
        passwordField = getView().findViewById(R.id.vLoginPasswordField);
        loginButton = getView().findViewById(R.id.vLoginLoginButton);
        signupButton = getView().findViewById(R.id.vLoginSignupButton);
        termsAndConditions = getView().findViewById(R.id.vLoginTermsAndConditionsText);
    }

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void setListeners() {
        termsAndConditions.setOnClickListener(it -> getPresenter().onTermsAndConditionsClicked());
        loginButton.setOnClickListener(it -> getPresenter()
                        .onLoginClicked(emailField.getText().toString(),
                                        passwordField.getText().toString()));
        signupButton.setOnClickListener(it -> getPresenter().onSignupClicked());
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
        emailField.setError(text);
    }

    @Override
    public void invalidatePassword(String text) {
        passwordField.setError(text);
    }

    @Override
    public void goToSignupView() {
        Intent intent = new Intent(getActivity(), SignupActivity.class);
        startActivity(intent);
    }

}
