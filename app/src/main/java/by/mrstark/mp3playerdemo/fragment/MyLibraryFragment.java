package by.mrstark.mp3playerdemo.fragment;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.adapter.TabsFragmentAdapter;
import by.mrstark.mp3playerdemo.constant.SystemDirectoryList;
import by.mrstark.mp3playerdemo.entity.Album;
import by.mrstark.mp3playerdemo.entity.Song;

/**
 * Created by mrstark on 27.1.16.
 */
public class MyLibraryFragment extends AbstractNavigationFragment {

    private static final int LAYOUT = R.layout.my_library;
    final String LOG_TAG = "myLogs";

    private ViewPager viewPager;
    private View root;
    private List<Song> songs;
    private List<Album> albums;

    public static MyLibraryFragment getInstance(Context context) {
        MyLibraryFragment fragment = new MyLibraryFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.my_library));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(LAYOUT, container, false);
        setSongs(findSongs(Environment.getExternalStorageDirectory()));
        setAlbums(songs);
        initTabs();
        return root;
    }

    private void setSongs(List<File> files) {
        songs = new ArrayList<>();
        for(File file: files) {
            songs.add(new Song(file));
        }
    }

    private void setAlbums(List<Song> songs) {
        albums = new ArrayList<>();
    }

    private void initTabs() {
        viewPager = (ViewPager) root.findViewById(R.id.view_pager);
        TabsFragmentAdapter adapter = new TabsFragmentAdapter(getContext(), getActivity().getSupportFragmentManager(), songs, albums);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        showArtistsTab();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void showArtistsTab() {
        viewPager.setCurrentItem(4);
    }

    private List<File> findSongs(File root) {
        ArrayList<File> songs = new ArrayList<>();
        File[] files = root.listFiles();
        if (files != null) {
            for(File file : files) {
                if (file.isDirectory() && !file.isHidden() && notSystemDirectory(file.getName())) {
                    songs.addAll(findSongs(file));
                } else {
                    if (file.getName().endsWith(".mp3")) {
                        songs.add(file);
                    }
                }
            }
        } else {
            Log.d(LOG_TAG, "Null");
        }
        return songs;
    }

    private boolean notSystemDirectory(String name) {
        for (int i = 0; i < SystemDirectoryList.list.length; i++) {
            if (name.equals(SystemDirectoryList.list[i])){
                return false;
            }
        }
        return true;
    }
}
