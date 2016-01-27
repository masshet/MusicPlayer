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
public class AlbumsFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_example;

    public static AlbumsFragment getInstance(Context context) {
        AlbumsFragment fragment = new AlbumsFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_albums));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(LAYOUT, container, false);
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
