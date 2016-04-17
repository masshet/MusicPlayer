package by.mrstark.mp3playerdemo.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.adapter.AlbumsListAdapter;

/**
 * Created by mrstark on 4/17/16.
 */
public class AlbumsFragment extends AbstractTabFragment {
    @Override
    public RecyclerView.Adapter getAdapter() {
        return new AlbumsListAdapter();
    }

    public static AlbumsFragment getInstance(Context context) {
        AlbumsFragment fragment = new AlbumsFragment();
        fragment.setTitle(context.getString(R.string.tab_item_albums));
        return fragment;
    }
}
