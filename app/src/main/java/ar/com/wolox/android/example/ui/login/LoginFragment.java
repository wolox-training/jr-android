package ar.com.wolox.android.example.ui.login;

import android.content.Intent;
import android.net.Uri;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 *
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
        getView().findViewById(R.id.terms_and_conditions_text)
                .setOnClickListener(it -> getPresenter().onTermsAndConditionsClicked());
        getView().findViewById(R.id.signup_button)
                .setOnClickListener(it -> getPresenter().onSignupClicked());
    }

    @Override
    public void openBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void goToSignupView() {
        // TODO
    }
}
