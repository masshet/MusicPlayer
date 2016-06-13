package by.mrstark.mp3playerdemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.mrstark.mp3playerdemo.R;

/**
 * Created by mrstark on 4/22/16.
 */
public abstract class AbstractTabletFragment extends Fragment {

    protected Fragment leftFragment;
    protected Fragment rightFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_column_view, container, false);

        initColumns();

        return root;
    }

    public abstract void initColumns();
}
