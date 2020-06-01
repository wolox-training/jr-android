package ar.com.wolox.android.example.ui.signup;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

public class SignupFragment extends WolmoFragment<SignupPresenter> {

    private static SignupFragment instance;

    private SignupFragment() {
    }

    public static SignupFragment newInstance() {
        if (instance == null) {
            instance = new SignupFragment();
        }
        return instance;
    }

    @Override
    public void init() {
    }

    @Override
    public int layout() {
        return R.layout.fragment_signup;
    }
}
