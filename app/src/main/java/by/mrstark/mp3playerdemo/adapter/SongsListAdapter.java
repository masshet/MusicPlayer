package by.mrstark.mp3playerdemo.adapter;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.entity.Song;
import by.mrstark.mp3playerdemo.fragment.SongsFragment;
import by.mrstark.mp3playerdemo.util.DataUtil;

/**
 * Created by mrstark on 11.2.16.
 */
public class SongsListAdapter extends RecyclerView.Adapter {


    private final SongsFragment.OnSongSelectedInterface listener;
    private List<Song> songs;

    public SongsListAdapter(SongsFragment.OnSongSelectedInterface listener, List<Song> songs) {
        this.listener = listener;
        this.songs = songs;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new SongListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SongListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    private class SongListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView art;
        private TextView title, artist;
        private int index;

        public SongListViewHolder(View itemView) {
            super(itemView);
            art = (ImageView) itemView.findViewById(R.id.item_art);
            title = (TextView) itemView.findViewById(R.id.item_title);
            artist = (TextView) itemView.findViewById(R.id.item_artist);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {
            index = position;
            Song song = songs.get(position);
            if (song.getAlbumArt() == null) {
                art.setImageResource(R.mipmap.ic_launcher);
            } else {
                art.setImageBitmap(BitmapFactory.decodeByteArray(song.getAlbumArt(), 0, song.getAlbumArt().length));
            }
            title.setText(song.getTitle());
            artist.setText(song.getArtist());
        }

        @Override
        public void onClick(View v) {
            listener.onListSongSelected(index, songs);
        }
    }
}
