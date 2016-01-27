package by.mrstark.mp3playerdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.mrstark.mp3playerdemo.R;

/**
 * Created by mrstark on 27.1.16.
 */
public class ListenNowFragment extends AbstractNavigationFragment {

    private static final int LAYOUT = R.layout.listen_now_fragment;

    public static ListenNowFragment getInstance(Context context) {
        ListenNowFragment fragment = new ListenNowFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.listen_now));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(LAYOUT, null, false);
        return root;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
