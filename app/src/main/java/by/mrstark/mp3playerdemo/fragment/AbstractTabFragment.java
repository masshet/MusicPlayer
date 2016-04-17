package by.mrstark.mp3playerdemo.fragment;

import android.content.Context;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.adapter.SongsListAdapter;

/**
 * Created by mrstark on 27.1.16.
 */
public abstract class AbstractTabFragment extends Fragment {

    private String title;
    protected View view;
    protected Context context;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_songs, container, false);

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.songRecycleView);
        recyclerView.setAdapter(getAdapter());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return root;
    }

    public abstract RecyclerView.Adapter getAdapter();
}
