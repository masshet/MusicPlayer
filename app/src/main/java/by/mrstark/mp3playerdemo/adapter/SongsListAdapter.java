package by.mrstark.mp3playerdemo.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.widget.RecyclerView;
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
import by.mrstark.mp3playerdemo.fragment.SongsFragment;
import by.mrstark.mp3playerdemo.util.DataUtil;

/**
 * Created by mrstark on 11.2.16.
 */
public class SongsListAdapter extends RecyclerView.Adapter {


    private final SongsFragment.OnSongSelectedinterface listener;

    public SongsListAdapter(SongsFragment.OnSongSelectedinterface listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list_item, parent, false);
        return new SongListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SongListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return DataUtil.getInstace().getSongs().size();
    }

    private class SongListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView art;
        private TextView title, artist;
        private int index;

        public SongListViewHolder(View itemView) {
            super(itemView);
            art = (ImageView) itemView.findViewById(R.id.item_album_art);
            title = (TextView) itemView.findViewById(R.id.item_song_title);
            artist = (TextView) itemView.findViewById(R.id.item_song_artist);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {
            index = position;
            Song song = DataUtil.getInstace().getSongs().get(position);
            art.setImageBitmap(BitmapFactory.decodeByteArray(song.getAlbumArt(), 0, song.getAlbumArt().length));
            title.setText(song.getTitle());
            artist.setText(song.getArtist());
        }

        @Override
        public void onClick(View v) {
            listener.onListSongSelected(index);
        }
    }
}
