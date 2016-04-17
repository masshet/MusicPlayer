package by.mrstark.mp3playerdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.adapter.TabsFragmentAdapter;

/**
 * Created by mrstark on 27.1.16.
 */
public class MyLibraryFragment extends AbstractNavigationFragment {

    private static final int LAYOUT = R.layout.fragment_my_library;

    private ViewPager viewPager;
    private View root;

    public static MyLibraryFragment getInstance(Context context) {
        MyLibraryFragment fragment = new MyLibraryFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.my_library));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(LAYOUT, container, false);
        initTabs();
        return root;
    }

    private void initTabs() {
        viewPager = (ViewPager) root.findViewById(R.id.view_pager);
        TabsFragmentAdapter adapter = new TabsFragmentAdapter(getContext(), getChildFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        showSongsTab();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void showSongsTab() {
        viewPager.setCurrentItem(4);
    }


}
