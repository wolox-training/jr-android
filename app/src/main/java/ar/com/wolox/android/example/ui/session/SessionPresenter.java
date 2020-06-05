package ar.com.wolox.android.example.ui.session;

import javax.inject.Inject;

import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import kotlin.text.StringsKt;

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
        if (StringsKt.isBlank(userSession.getUsername())) {
            getView().goToLoginPage();
        } else {
            getView().goToHome();
        }
    }
}
