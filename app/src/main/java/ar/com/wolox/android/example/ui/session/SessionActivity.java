package ar.com.wolox.android.example.ui.session;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeFragment;
import ar.com.wolox.android.example.ui.login.LoginFragment;
import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 *  Session activity. It will be in charge of managing the logged user's info.
 */
public class SessionActivity extends WolmoActivity {

    @Inject
    public UserSession userSession;

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    @Override
    protected void init() {
        userSession.setUsername("");
        if (userSession.isOngoingSession()) {
            replaceFragment(R.id.vActivityBaseContent, LoginFragment.newInstance());
        } else {
            replaceFragment(R.id.vActivityBaseContent, HomeFragment.newInstance());
        }
    }
}
