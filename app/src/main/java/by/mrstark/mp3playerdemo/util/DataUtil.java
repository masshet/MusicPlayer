package by.mrstark.mp3playerdemo.util;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import by.mrstark.mp3playerdemo.constant.SystemDirectoryList;
import by.mrstark.mp3playerdemo.entity.Album;
import by.mrstark.mp3playerdemo.entity.Artist;
import by.mrstark.mp3playerdemo.entity.Song;

/**
 * Created by mrstark on 4/16/16.
 */
public class DataUtil {

    final String LOG_TAG = "myLogs";

    private List<Song> songs;
    private List<Album> albums;
    private List<Artist> artists;
    private static DataUtil dataUtil;

    public static DataUtil getInstace() {
        if (dataUtil == null) {
            dataUtil =  new DataUtil();
        }
        return dataUtil;
    }

    private DataUtil() {
        setSongs(findSongs(Environment.getExternalStorageDirectory()));
        setAlbums();
//        setArtists();
    }

    public List<Song> getSongs() {
        return songs;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    private void setArtists() {
        artists = new ArrayList<>();
        for (Album album : albums) {
            if (artists.contains(new Artist(album.getArtist()))) {
                for (Artist artist : artists) {
                    if (artist.getName().equals(album.getArtist())) {
                        artist.addAlbum(album);
                    }
                }
            } else {
                artists.add(createArtistWithOneAlbum(album));
            }
        }
    }

    private Artist createArtistWithOneAlbum(Album album) {
        Artist artist = new Artist(album.getArtist());
        Log.d(LOG_TAG, album.getArtist());
        artist.addAlbum(album);
        return artist;
    }

    private void setAlbums() {
        albums = new ArrayList<>();
        for (Song song : songs) {
            if (song.getAlbum().length() != 0) {
                if (albums.contains(new Album(song.getArtist(), song.getAlbum()))) {
                    for (Album album : albums) {
                        if (album.getName().equals(song.getAlbum()) && album.getArtist().equals(song.getArtist())) {
                            album.addSong(song);
                        }
                    }
                } else {
                    albums.add(createAlbumWithOneSong(song));
                }
            }
        }
    }

    private Album createAlbumWithOneSong(Song song) {
        Album album = new Album(song.getArtist(), song.getAlbum());
        album.addSong(song);
        return album;
    }

    private void setSongs(List<File> files) {
        songs = new ArrayList<>();
        for(File file: files) {
            songs.add(new Song(file));
        }
    }

    private List<File> findSongs(File root) {
        ArrayList<File> songs = new ArrayList<>();
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory() && !file.isHidden() && notSystemDirectory(file.getName())) {
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

    private boolean notSystemDirectory(String name) {
        for (int i = 0; i < SystemDirectoryList.list.length; i++) {
            if (name.equals(SystemDirectoryList.list[i])){
                return false;
            }
        }
        return true;
    }
}
