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
import by.mrstark.mp3playerdemo.entity.Genre;
import by.mrstark.mp3playerdemo.fragment.GenresFragment;
import by.mrstark.mp3playerdemo.util.DataUtil;

/**
 * Created by mrstark on 4/18/16.
 */
public class GenresListAdapter extends RecyclerView.Adapter {
    private final GenresFragment.OnGenreSelectedInterface listener;

    public GenresListAdapter(GenresFragment.OnGenreSelectedInterface listener) {
        this.listener = listener;
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
        return DataUtil.getInstace().getGenres().size();
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
            Genre genre = DataUtil.getInstace().getGenres().get(position);
            if (genre.getAlbums().get(0).getAlbumArt().length == 0) {
                art.setImageResource(R.mipmap.ic_launcher);
            } else {
                art.setImageBitmap(BitmapFactory.decodeByteArray(genre.getAlbums().get(0).getAlbumArt(), 0, genre.getAlbums().get(0).getAlbumArt().length));
            }
            title.setText(genre.getName());
        }

        @Override
        public void onClick(View v) {
            listener.onGenreSelect(DataUtil.getInstace().getGenres().get(index).getName());
        }
    }
}
