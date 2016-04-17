package by.mrstark.mp3playerdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.mrstark.mp3playerdemo.R;

/**
 * Created by mrstark on 27.1.16.
 */
public class ListenNowFragment extends AbstractNavigationFragment {

    private static final int LAYOUT = R.layout.fragment_listen_now;

    public static ListenNowFragment getInstance(Context context) {
        ListenNowFragment fragment = new ListenNowFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.listen_now));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(LAYOUT, container, false);
        return root;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
