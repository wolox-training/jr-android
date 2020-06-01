package ar.com.wolox.android.example.ui.login;

import javax.inject.Inject;

import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 *
 */
public class SignupPresenter extends BasePresenter<SignupView> {

    private UserSession userSession;

    @Inject
    public SignupPresenter(UserSession userSession) {
        this.userSession = userSession;
    }
}
