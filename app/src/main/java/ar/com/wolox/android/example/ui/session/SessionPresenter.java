package ar.com.wolox.android.example.ui.session;

import com.google.common.base.Strings;

import javax.inject.Inject;

import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 *  Session presenter class
 */
public class SessionPresenter extends BasePresenter<SessionView> {

    private UserSession userSession;

    @Inject
    public SessionPresenter(UserSession userSession) {
        this.userSession = userSession;
    }

    public void loadUserInfo() {
        if (Strings.isNullOrEmpty(userSession.getUsername())) {
            getView().goToLoginPage();
        } else {
            getView().goToHome();
        }
    }
}
