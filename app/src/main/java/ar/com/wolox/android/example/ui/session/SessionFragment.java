package ar.com.wolox.android.example.ui.session;

import android.content.Intent;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.android.example.ui.login.LoginActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 *  Session fragment class
 */
public class SessionFragment extends WolmoFragment<SessionPresenter> implements SessionView {

    private static SessionFragment instance;

    public static SessionFragment newInstance() {
        if (instance == null) {
            instance = new SessionFragment();
        }
        return instance;
    }

    @Override
    public void init() {
        getPresenter().loadUserInfo();
    }

    @Override
    public int layout() {
        return R.layout.activity_base;
    }

    @Override
    public void goToHome() {
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToLoginPage() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
