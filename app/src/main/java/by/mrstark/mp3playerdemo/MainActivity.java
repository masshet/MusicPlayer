package by.mrstark.mp3playerdemo;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import by.mrstark.mp3playerdemo.fragment.ListenNowFragment;

/**
 * Created by mrstark on 22.1.16.
 */
public class MainActivity extends FragmentActivity {

    private static final String FILE_NAME = "01 Не с начала.mp3";
    final String LOG_TAG = "myLogs";

    private ListenNowFragment listenNowFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Toolbar toolbar;
    private DrawerLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        listenNowFragment = new ListenNowFragment();

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
        transaction.add(R.id.container, listenNowFragment);
        transaction.commit();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
    }

    private void initNavigationView() {
        layout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, layout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        layout.setDrawerListener(toggle);
        toggle.syncState();
    }

/*    public void initPlayer() {
        player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String path = Environment.getExternalStorageDirectory().getPath() + "/" + FILE_NAME;
        retriever = new MediaMetadataRetriever();
        retriever.setDataSource(path);
        artist.setText(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
        song.setText(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
        album.setText(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
        albumArt.setImageBitmap(BitmapFactory.decodeByteArray(retriever.getEmbeddedPicture(), 0, retriever.getEmbeddedPicture().length));
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

    private List<File> findSongs(File root) {
        ArrayList<File> songs = new ArrayList<>();
        File[] files = root.listFiles();
        if (files != null) {
            for(File file : files) {
                if (file.isDirectory() && !file.isHidden()) {
                    songs.addAll(findSongs(file));
                } else {
                    if (file.getName().endsWith(".mp3")) {
                        songs.add(file);
                    }
                }
            }
        } else {
            Log.d(LOG_TAG, "Null");
        }
        return songs;
    }

    public void onClickPlay(View view) {
        initPlayer();
        player.start();
        Log.d(LOG_TAG, "Playing " + player.isPlaying());
        play.hide();
        pause.show();
    }

    public void onClickPause(View view) {
        player.pause();
        Log.d(LOG_TAG, "Playing " + player.isPlaying());
        pause.hide();
        play.show();
    }*/
}
