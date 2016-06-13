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
 * Created by mrstark on 4/22/16.
 */
public class TabletFragment extends Fragment {

    SongsFragment songsFragment;
    AlbumsFragment albumsFragment;
    ArtistsFragment artistsFragment;

    FragmentManager manager;
    FragmentTransaction transaction;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_column_view, container, false);

        manager = getChildFragmentManager();

        initFragments();

        transaction = manager.beginTransaction();
        transaction.add(R.id.left_column, artistsFragment);
        transaction.commit();

        return root;
    }

    private void initFragments() {
        songsFragment = new SongsFragment();
        albumsFragment = new AlbumsFragment().getInstance(getContext());
        artistsFragment = new ArtistsFragment().getInstance(getContext());
    }

    public void changeFragment(int index) {
        switch (index) {
            case 0:
                replaceFragment(null);
                break;
            case 1:
                replaceFragment(songsFragment);
                break;
            case 2:
                replaceFragment(artistsFragment);
                break;
            case 3:
                replaceFragment(albumsFragment);
                break;
            case 4:
                replaceFragment(null);
                break;
            default: return;
        }
    }

    private void replaceFragment(Fragment fragment) {
        transaction = manager.beginTransaction();
        transaction.replace(R.id.left_column, fragment);
        transaction.commit();
    }
}
