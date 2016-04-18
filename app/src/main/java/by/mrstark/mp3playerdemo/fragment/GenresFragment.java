package by.mrstark.mp3playerdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.adapter.GenresListAdapter;

/**
 * Created by mrstark on 27.1.16.
 */
public class GenresFragment extends AbstractTabFragment {

    public static GenresFragment getInstance(Context context) {
        GenresFragment fragment = new GenresFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_genres));
        return fragment;
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new GenresListAdapter();
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
