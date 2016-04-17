package by.mrstark.mp3playerdemo.adapter;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.entity.Artist;
import by.mrstark.mp3playerdemo.util.DataUtil;

/**
 * Created by mrstark on 4/17/16.
 */
public class ArtistsListAdapter extends RecyclerView.Adapter {
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
        return DataUtil.getInstace().getArtists().size();
    }

    private class ArtistListViewHolder extends RecyclerView.ViewHolder {

        private ImageView art;
        private TextView title;
        private int index;

        public ArtistListViewHolder(View itemView) {
            super(itemView);
            art = (ImageView) itemView.findViewById(R.id.item_art);
            title = (TextView) itemView.findViewById(R.id.item_title);
        }

        public void bindView(int position) {
            index = position;
            Artist artist = DataUtil.getInstace().getArtists().get(position);
            if (artist.getAlbums().get(0).getAlbumArt().length == 0) {
                art.setImageResource(R.mipmap.ic_launcher);
            } else {
                art.setImageBitmap(BitmapFactory.decodeByteArray(artist.getAlbums().get(0).getAlbumArt(), 0, artist.getAlbums().get(0).getAlbumArt().length));
            }
            title.setText(artist.getName());
        }
    }
}
