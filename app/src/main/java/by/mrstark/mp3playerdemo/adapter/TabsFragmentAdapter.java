package by.mrstark.mp3playerdemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;

import by.mrstark.mp3playerdemo.fragment.AbstractTabFragment;
import by.mrstark.mp3playerdemo.fragment.AlbumsFragment;
import by.mrstark.mp3playerdemo.fragment.ArtistsFragment;
import by.mrstark.mp3playerdemo.fragment.GenresFragment;
import by.mrstark.mp3playerdemo.fragment.PlaylistsFragment;
import by.mrstark.mp3playerdemo.fragment.SongsFragment;

/**
 * Created by mrstark on 27.1.16.
 */
public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> map;
    private Context context;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initTabsMap();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return map.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return map.get(position);
    }

    @Override
    public int getCount() {
        return map.size();
    }

    private void initTabsMap() {
        map = new HashMap<>();
        map.put(0, PlaylistsFragment.getInstance(context));
        map.put(1, GenresFragment.getInstance(context));
        map.put(2, ArtistsFragment.getInstance(context));
        map.put(3, AlbumsFragment.getInstance(context));
        map.put(4, SongsFragment.getInstance(context));
    }
}
