package by.mrstark.mp3playerdemo.entity;

import java.util.ArrayList;

/**
 * Created by mrstark on 15.2.16.
 */
public class PlaylistForPlaying {

    private ArrayList<Song> songs;
    private static PlaylistForPlaying instance;


    private PlaylistForPlaying() {}

    public static PlaylistForPlaying getInstance() {
        if (instance == null) {
            instance = new PlaylistForPlaying();
        }
        return instance;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
