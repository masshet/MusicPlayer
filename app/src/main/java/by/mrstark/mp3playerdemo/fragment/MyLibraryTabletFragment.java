package by.mrstark.mp3playerdemo.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.mrstark.mp3playerdemo.R;

/**
 * Created by mrstark on 4/19/16.
 */
public class MyLibraryTabletFragment extends Fragment {
    FragmentManager manager;
    FragmentTransaction transaction;
    TabletFragment tabletFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_column_view, container, false);

        CategoryFragment fragment = new CategoryFragment();
        tabletFragment = new TabletFragment();
        manager = getChildFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.left_column, fragment);
        transaction.add(R.id.right_column, tabletFragment);
        transaction.commit();

        return root;
    }
}
