package ar.com.wolox.android.example.ui.session;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 *  Session activity. It will be in charge of managing the logged user's info.
 */
public class SessionActivity extends WolmoActivity {
    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    @Override
    protected void init() {
        replaceFragment(R.id.vActivityBaseContent, SessionFragment.newInstance());
    }
}