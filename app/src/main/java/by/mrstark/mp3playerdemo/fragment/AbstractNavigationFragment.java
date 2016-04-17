package by.mrstark.mp3playerdemo.fragment;

import android.app.Fragment;
import android.content.Context;
import android.view.View;

/**
 * Created by mrstark on 27.1.16.
 */
public class AbstractNavigationFragment extends Fragment {

    private String title;
    protected View view;
    protected Context context;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
