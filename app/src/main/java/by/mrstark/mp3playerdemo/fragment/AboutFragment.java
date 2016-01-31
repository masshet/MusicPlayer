package by.mrstark.mp3playerdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.mrstark.mp3playerdemo.R;

/**
 * Created by mrstark on 31.1.16.
 */
public class AboutFragment extends AbstractNavigationFragment {

    private static final int LAYOUT = R.layout.about_fragment;

    public static AboutFragment getInstance(Context context) {
        AboutFragment fragment = new AboutFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.about));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(LAYOUT, null, false);
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
