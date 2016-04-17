package by.mrstark.mp3playerdemo.adapter;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.entity.Album;
import by.mrstark.mp3playerdemo.util.DataUtil;

/**
 * Created by mrstark on 4/17/16.
 */
public class AlbumsListAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new AlbumListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((AlbumListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return DataUtil.getInstace().getAlbums().size();
    }

    private class AlbumListViewHolder extends RecyclerView.ViewHolder {

        private ImageView art;
        private TextView title, artist;
        private int index;

        public AlbumListViewHolder(View itemView) {
            super(itemView);
            art = (ImageView) itemView.findViewById(R.id.item_art);
            title = (TextView) itemView.findViewById(R.id.item_title);
            artist = (TextView) itemView.findViewById(R.id.item_artist);
        }

        public void bindView(int position) {
            index = position;
            Album album = DataUtil.getInstace().getAlbums().get(position);
            if (album.getAlbumArt().length == 0) {
                art.setImageResource(R.mipmap.ic_launcher);
            } else {
                art.setImageBitmap(BitmapFactory.decodeByteArray(album.getAlbumArt(), 0, album.getAlbumArt().length));
            }
            title.setText(album.getName());
            artist.setText(album.getArtist());
        }
    }
}
