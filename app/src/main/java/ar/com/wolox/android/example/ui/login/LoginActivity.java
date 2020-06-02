package ar.com.wolox.android.example.ui.login;

import android.content.Context;
import android.content.SharedPreferences;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeFragment;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 *  Login activity class
 */
public class LoginActivity extends WolmoActivity {
    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    @Override
    protected void init() {
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        if (preferences.contains("preference_login_email") && preferences.contains("preference_login_password")) {
            replaceFragment(R.id.vActivityBaseContent, HomeFragment.newInstance());
        } else {
            replaceFragment(R.id.vActivityBaseContent, LoginFragment.newInstance());
        }
    }

}
