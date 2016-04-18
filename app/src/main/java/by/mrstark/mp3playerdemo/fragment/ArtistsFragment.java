package by.mrstark.mp3playerdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.adapter.ArtistsListAdapter;

/**
 * Created by mrstark on 27.1.16.
 */
public class ArtistsFragment extends AbstractTabFragment {

    public static ArtistsFragment getInstance(Context context) {
        ArtistsFragment fragment = new ArtistsFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_artists));
        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new ArtistsListAdapter();
    }
}
