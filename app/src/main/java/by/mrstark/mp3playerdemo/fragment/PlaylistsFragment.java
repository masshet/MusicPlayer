package by.mrstark.mp3playerdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import by.mrstark.mp3playerdemo.R;

/**
 * Created by mrstark on 27.1.16.
 */
public class PlaylistsFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.playlists_fragment;

    private FloatingActionButton button;
    private Animation fabOpen;

    public static PlaylistsFragment getInstance(Context context) {
        PlaylistsFragment fragment = new PlaylistsFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_playlists));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(LAYOUT, container, false);
        initFAB(root);
        return root;
    }

    public void initFAB(View view) {
        button = (FloatingActionButton) view.findViewById(R.id.fab_add_playlist);
        fabOpen = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fab_open);
        button.startAnimation(fabOpen);
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
