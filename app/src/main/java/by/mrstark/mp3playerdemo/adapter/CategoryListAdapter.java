package by.mrstark.mp3playerdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.fragment.CategoryFragment;

public class CategoryListAdapter extends RecyclerView.Adapter {
    private String[] categories = new String[]{"PLAYLISTS", "SONGS", "ARTISTS", "ALBUMS", "GENRES"};

    private CategoryFragment.OnCategorySelectedInterface listener;

    public CategoryListAdapter(CategoryFragment.OnCategorySelectedInterface listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);
        return new CategoryListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CategoryListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return categories.length;
    }

    private class CategoryListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView category;
        private int index;

        public CategoryListViewHolder(View itemView) {
            super(itemView);
            category = (TextView) itemView.findViewById(R.id.category_list_item);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {
            index = position;
            category.setText(categories[position]);
        }

        @Override
        public void onClick(View v) {
            Log.d("TAG", index + "");
            listener.onCategorySelected(index);
        }
    }
}
