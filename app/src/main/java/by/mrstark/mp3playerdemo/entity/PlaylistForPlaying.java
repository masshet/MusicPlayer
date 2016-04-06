package by.mrstark.mp3playerdemo.entity;

import java.util.List;

/**
 * Created by mrstark on 15.2.16.
 */
public class PlaylistForPlaying {

    private List<Song> songs;
    private static PlaylistForPlaying instance;


    private PlaylistForPlaying() {}

    public static PlaylistForPlaying getInstance() {
        if (instance == null) {
            instance = new PlaylistForPlaying();
        }
        return instance;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
