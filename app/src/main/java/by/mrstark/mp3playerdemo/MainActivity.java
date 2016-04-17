package by.mrstark.mp3playerdemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import by.mrstark.mp3playerdemo.fragment.AboutFragment;
import by.mrstark.mp3playerdemo.fragment.AbstractNavigationFragment;
import by.mrstark.mp3playerdemo.fragment.ListenNowFragment;
import by.mrstark.mp3playerdemo.fragment.MyLibraryFragment;
import by.mrstark.mp3playerdemo.fragment.SongsFragment;
import by.mrstark.mp3playerdemo.util.DataUtil;

/**
 * Created by mrstark on 22.1.16.
 */
public class MainActivity extends AppCompatActivity implements SongsFragment.OnSongSelectedinterface {

    final String LOG_TAG = "myLogs";

    private ListenNowFragment listenNowFragment;
    private MyLibraryFragment myLibraryFragment;
    private AboutFragment aboutFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Toolbar toolbar;
    private DrawerLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();

        initToolbar();
        initNavigationView();

        AbstractNavigationFragment savedFragment = (AbstractNavigationFragment) manager.findFragmentById(R.id.container);
        if (savedFragment == null) {
            loadFragment();
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }

    public void loadFragment() {
        listenNowFragment = ListenNowFragment.getInstance(this);
        aboutFragment = AboutFragment.getInstance(this);
        myLibraryFragment = MyLibraryFragment.getInstance(this);
        transaction = manager.beginTransaction();
        transaction.add(R.id.container, myLibraryFragment);
        transaction.commit();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.my_library);
        toolbar.inflateMenu(R.menu.menu);
    }

    public void changeFragment(Fragment fragment) {
        transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    private void initNavigationView() {
        layout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, layout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        layout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        if  (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

                @Nullable
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    layout.closeDrawers();
                    switch (item.getItemId()) {
                        case R.id.listen_now_menu_item:
                            toolbar.setTitle(R.string.listen_now);
                            changeFragment(listenNowFragment);
                            break;
                        case R.id.my_library_menu_item:
                            toolbar.setTitle(R.string.my_library);
                            changeFragment(myLibraryFragment);
                            break;
                        case R.id.about_menu_item:
                            toolbar.setTitle(R.string.about);
                            changeFragment(aboutFragment);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
        }

    }

    @Override
    public void onListSongSelected(int index) {
        Toast.makeText(getApplicationContext(), DataUtil.getInstace().getSongs().get(index).getTitle(), Toast.LENGTH_LONG).show();
    }
}
