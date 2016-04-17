package by.mrstark.mp3playerdemo.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.activity.PlayActivity;
import by.mrstark.mp3playerdemo.adapter.SongsListAdapter;
import by.mrstark.mp3playerdemo.entity.PlaylistForPlaying;
import by.mrstark.mp3playerdemo.entity.Song;
import by.mrstark.mp3playerdemo.util.DataUtil;

/**
 * Created by mrstark on 27.1.16.
 */
public class SongsFragment extends AbstractTabFragment {

    public interface OnSongSelectedinterface {
        void onListSongSelected(int index);
    }

    public static SongsFragment getInstance(Context context) {
        SongsFragment fragment = new SongsFragment();
        fragment.setTitle(context.getString(R.string.tab_item_songs));
        return fragment;
    }

    public RecyclerView.Adapter getAdapter() {
        OnSongSelectedinterface listener = (OnSongSelectedinterface) getActivity();
        SongsListAdapter songsListAdapter = new SongsListAdapter(listener);
        return songsListAdapter;
    }
}
