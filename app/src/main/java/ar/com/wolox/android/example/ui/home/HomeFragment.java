package ar.com.wolox.android.example.ui.home;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

public class HomeFragment extends WolmoFragment<HomePresenter> {

    private static HomeFragment instance;

    private HomeFragment() {
    }

    public static HomeFragment newInstance() {
        if (instance == null) {
            instance = new HomeFragment();
        }
        return instance;
    }

    @Override
    public void init() {
    }

    @Override
    public int layout() {
        return R.layout.fragment_home;
    }
}
