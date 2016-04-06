package by.mrstark.mp3playerdemo.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.entity.Song;

/**
 * Created by mrstark on 11.2.16.
 */
public class SongsListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<Song> songs;

    public SongsListAdapter(Context context, List<Song> songs) {
        this.context = context;
        this.songs = songs;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int position) {
        return songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.song_list_item, parent, false);
        }
        Song song = getSong(position);
        ((TextView) view.findViewById(R.id.item_song_title)).setText(song.getTitle());
        ((TextView) view.findViewById(R.id.item_song_artist)).setText(song.getArtist());
        ((ImageView) view.findViewById(R.id.item_album_art)).setImageBitmap(BitmapFactory.decodeByteArray(song.getAlbumArt(), 0, song.getAlbumArt().length));
        return view;
    }

    private Song getSong(int position) {
        return ((Song) getItem(position));
    }
}
