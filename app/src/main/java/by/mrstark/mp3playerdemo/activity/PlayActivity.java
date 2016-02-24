package by.mrstark.mp3playerdemo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

import by.mrstark.mp3playerdemo.R;
import by.mrstark.mp3playerdemo.entity.PlaylistForPlaying;
import by.mrstark.mp3playerdemo.entity.Song;

/**
 * Created by mrstark on 15.2.16.
 */
public class PlayActivity extends AppCompatActivity {

    private ImageView background;
    private Toolbar toolbar;
    private int songId;
    private Song song;
    private MediaPlayer player;
    private FloatingActionButton play, pause, next, previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_fragment);
        songId = this.getIntent().getExtras().getInt("id");
        song = PlaylistForPlaying.getInstance().getSongs().get(songId);
        initToolbar();
        initFooter();
        initPlayer();
    }

    private void initFooter() {
        play = (FloatingActionButton) findViewById(R.id.play_button);
        pause = (FloatingActionButton) findViewById(R.id.pause_button);
        next = (FloatingActionButton) findViewById(R.id.skip_next_button);
        previous = (FloatingActionButton) findViewById(R.id.skip_previous_button);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        background = (ImageView) findViewById(R.id.background);
        setContent();
//        toolbar.setLogo(new BitmapDrawable(getResources(), bitmap));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play_button:
                play.hide();
                pause.show();
                player.start();
                break;
            case R.id.pause_button:
                pause.hide();
                play.show();
                player.pause();
                break;
            case R.id.skip_next_button:
                playNext();
                break;
            case R.id.skip_previous_button:
                playPrevious();
                break;
        }
    }

    private void playPrevious() {
        if (songId == 0) {
            songId = PlaylistForPlaying.getInstance().getSongs().size() - 1;
        } else {
            songId--;
        }
        song = PlaylistForPlaying.getInstance().getSongs().get(songId);
        setContent();
        setSong();
    }

    private void playNext() {
        if (songId == PlaylistForPlaying.getInstance().getSongs().size() - 1) {
            songId = 0;
        } else {
            songId++;
        }
        song = PlaylistForPlaying.getInstance().getSongs().get(songId);
        setContent();
        setSong();
    }

    private void setSong() {
        if (player != null) {
            if (player.isPlaying()) {
                player.stop();
            }
            player.reset();
        }
        String path = song.getPath();
        try {
            player.setDataSource(this, Uri.parse(path));
            player.setLooping(true);
            player.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }
        onClick(play);
    }

    private void setContent() {
        Bitmap bitmap = BitmapFactory.decodeByteArray(song.getAlbumArt(), 0, song.getAlbumArt().length);
        background.setImageBitmap(bitmap);
        toolbar.setTitle(song.getTitle());
        toolbar.setSubtitle(song.getArtist());
    }

    private void initPlayer() {
        player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        setSong();
    }
}
