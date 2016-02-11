package by.mrstark.mp3playerdemo;

import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.mrstark.mp3playerdemo.fragment.AboutFragment;
import by.mrstark.mp3playerdemo.fragment.ListenNowFragment;
import by.mrstark.mp3playerdemo.fragment.MyLibraryFragment;

/**
 * Created by mrstark on 22.1.16.
 */
public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "01 Не с начала.mp3";
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

        manager = getSupportFragmentManager();

        listenNowFragment = ListenNowFragment.getInstance(this);
        myLibraryFragment = MyLibraryFragment.getInstance(this);
        aboutFragment = AboutFragment.getInstance(this);

        initToolbar();
        initNavigationView();

        loadFragment();

//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
//        } else {

//            ArrayList<File> list = findSongs(Environment.getExternalStorageDirectory());
//        }
    }

    public void loadFragment() {
        transaction = manager.beginTransaction();
        transaction.add(R.id.container, myLibraryFragment);
        transaction.commit();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.listen_now);
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
        layout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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
                }
                return true;
            }
        });

    }

    public void initPlayer() {
        MediaPlayer player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String path = Environment.getExternalStorageDirectory().getPath() + "/" + FILE_NAME;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(path);
        String artist = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
        String song = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
        String album = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
        byte[] albumArt = retriever.getEmbeddedPicture();
        Log.d(LOG_TAG, "Playing " + path);
        try {
            player.setDataSource(this, Uri.parse(path));
            player.setLooping(true);
            player.prepare();
        } catch (IOException e) {
            Log.d(LOG_TAG, e.getMessage());
            e.printStackTrace();
        }
    }


}
