package by.mrstark.mp3playerdemo.entity;

import java.util.List;

/**
 * Created by mrstark on 10.2.16.
 */
public class Album {

    private String artist;
    private String name;
    private List<Song> songsList;

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
    }

    public void addSong(Song song) {
        songsList.add(song);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongsList() {
        return songsList;
    }

    public void setSongsList(List<Song> songsList) {
        this.songsList = songsList;
    }
}
