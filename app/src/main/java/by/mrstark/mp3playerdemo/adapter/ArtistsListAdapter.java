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
import by.mrstark.mp3playerdemo.entity.Artist;
import by.mrstark.mp3playerdemo.fragment.ArtistsFragment;
import by.mrstark.mp3playerdemo.util.DataUtil;

/**
 * Created by mrstark on 4/17/16.
 */
public class ArtistsListAdapter extends RecyclerView.Adapter {
    private final ArtistsFragment.OnArtistSelectedInterface listener;
    private List<Artist> artists;

    public ArtistsListAdapter(ArtistsFragment.OnArtistSelectedInterface listener, List<Artist> artists) {
        this.listener = listener;
        this.artists = artists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ArtistListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ArtistListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    private class ArtistListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView art;
        private TextView title;
        private int index;

        public ArtistListViewHolder(View itemView) {
            super(itemView);
            art = (ImageView) itemView.findViewById(R.id.item_art);
            title = (TextView) itemView.findViewById(R.id.item_title);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {
            index = position;
            Artist artist = artists.get(position);
            if (artist.getAlbums().get(0).getAlbumArt().length == 0) {
                art.setImageResource(R.mipmap.ic_launcher);
            } else {
                art.setImageBitmap(BitmapFactory.decodeByteArray(artist.getAlbums().get(0).getAlbumArt(), 0, artist.getAlbums().get(0).getAlbumArt().length));
            }
            title.setText(artist.getName());
        }

        @Override
        public void onClick(View v) {
            listener.onArtistSelect(artists.get(index).getName());
        }
    }
}
