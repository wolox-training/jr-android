package ar.com.wolox.android.example.ui.login;

import android.content.Intent;
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
    private static final String REGEX_EMAIL = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";

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
                .setOnClickListener(it -> getPresenter().onLoginClicked());
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
        if (!anyFieldsAreEmpty() && !emailIsInvalid()) {
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void goToSignupView() {
        Intent intent = new Intent(getActivity(), SignupActivity.class);
        startActivity(intent);
    }

    private boolean anyFieldsAreEmpty() {
        TextView email = getView().findViewById(R.id.vLoginEmailField);
        boolean emailIsEmpty = "".equals(email.getText().toString());

        TextView password = getView().findViewById(R.id.vLoginPasswordField);
        boolean passwordIsEmpty = "".equals(password.getText().toString());

        if (emailIsEmpty) {
            email.setError("The email is required.");
        }
        if (passwordIsEmpty) {
            password.setError("The password is required.");
        }

        return emailIsEmpty || passwordIsEmpty;
    }

    private boolean emailIsInvalid() {
        TextView email = getView().findViewById(R.id.vLoginEmailField);

        boolean emailIsInvalid = !email.getText().toString().matches(REGEX_EMAIL);

        if (emailIsInvalid) {
            email.setError("The email does not have the correct format.");
        }

        return emailIsInvalid;
    }

}
