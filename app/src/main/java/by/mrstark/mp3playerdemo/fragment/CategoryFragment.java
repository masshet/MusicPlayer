package by.mrstark.mp3playerdemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.adapter.CategoryListAdapter;

/**
 * Created by mrstark on 4/19/16.
 */
public class CategoryFragment extends Fragment {
    public interface OnCategorySelectedInterface {
        void onCategorySelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_catgory, container, false);

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.category_list);
        recyclerView.setAdapter(getAdapter());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return root;
    }

    public RecyclerView.Adapter getAdapter() {
        CategoryListAdapter adapter = new CategoryListAdapter(null);
        return adapter;
    }
}
