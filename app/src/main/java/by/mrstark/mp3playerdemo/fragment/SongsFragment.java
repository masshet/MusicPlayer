package by.mrstark.mp3playerdemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.CharacterPickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.activity.PlayActivity;
import by.mrstark.mp3playerdemo.adapter.SongsListAdapter;
import by.mrstark.mp3playerdemo.entity.PlaylistForPlaying;
import by.mrstark.mp3playerdemo.entity.Song;

/**
 * Created by mrstark on 27.1.16.
 */
public class SongsFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.songs_fragment;

    private ListView listView;
    private ArrayList<Song> songs;

    private SongsFragment(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public static SongsFragment getInstance(Context context, ArrayList<Song> songs) {
        SongsFragment fragment = new SongsFragment(songs);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_songs));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(LAYOUT, container, false);
        listView = (ListView) root.findViewById(R.id.song_list);
        SongsListAdapter adapter = new SongsListAdapter(getActivity().getApplicationContext(), songs);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PlaylistForPlaying playlistForPlaying = PlaylistForPlaying.getInstance();
                playlistForPlaying.setSongs(songs);
                Intent intent = new Intent(getActivity().getApplicationContext(), PlayActivity.class);
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });
        return root;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
