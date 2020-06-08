package ar.com.wolox.android.example.ui.login;

import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.android.example.ui.signup.SignupActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

public final class LoginFragment extends WolmoFragment<LoginPresenter> implements LoginView {

    private static LoginFragment instance;

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
    public void invalidateEmptyEmail() {
        emailField.setError(getString(R.string.error_empty_email));
    }

    @Override
    public void invalidateEmailFormat() {
        emailField.setError(getString(R.string.error_invalid_email));
    }

    @Override
    public void invalidateEmptyPassword() {
        passwordField.setError(getString(R.string.error_empty_password));
    }

    @Override
    public void invalidateLogin() {
        generateToastError(getString(R.string.error_bad_login));
    }

    @Override
    public void invalidateConnection() {
        generateToastError(getString(R.string.error_connection));
    }

    @Override
    public void showLoading() {
        getView().findViewById(R.id.vLoginProgressBar).setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        getView().findViewById(R.id.vLoginProgressBar).setVisibility(View.INVISIBLE);
    }

    @Override
    public void goToSignupView() {
        Intent intent = new Intent(getActivity(), SignupActivity.class);
        startActivity(intent);
    }

    private void generateToastError(String errorMessage) {
        Toast toast = Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER,
                0, (int) getResources().getDimension(R.dimen.spacing_huge_extra));
        toast.show();
    }
}
