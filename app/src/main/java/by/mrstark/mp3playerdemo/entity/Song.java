package by.mrstark.mp3playerdemo.entity;

import android.media.MediaMetadataRetriever;
import android.util.Log;

import java.io.File;

/**
 * Created by mrstark on 10.2.16.
 */
public class Song {

    private String title;
    private String artist;
    private String album;
    private String genre;
    byte[] albumArt;
    private String path;

    public Song(File file) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(file.getAbsolutePath());
        setTitle(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
        setArtist(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
        setAlbum(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
        setGenre(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE));
        setAlbumArt(retriever.getEmbeddedPicture());
        setPath(file.getAbsolutePath());
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        if (path != null) {
            this.path = path;
        }
    }

    public String getTitle() {
        if (title != null) {
            return title;
        }
        return "";
    }

    public void setTitle(String title) {
        if (title != null) {
            this.title = title;
        }
    }

    public String getArtist() {
        if (artist != null) {
            return artist;
        }
        return "";
    }

    public void setArtist(String artist) {
        if (artist != null) {
            this.artist = artist;
        }
    }

    public String getAlbum() {
        if (album != null) {
            return album;
        }
        return "";
    }

    public void setAlbum(String album) {
        if (album != null) {
            this.album = album;
        }
    }

    public String getGenre() {
        if (genre != null) {
            return genre;
        }
        return "";
    }

    public void setGenre(String genre) {
        if (genre != null) {
            this.genre = genre;
        }
    }

    public byte[] getAlbumArt() {
        if (albumArt != null) {
            return albumArt;
        }
        return new byte[]{};
    }

    public void setAlbumArt(byte[] albumArt) {
        if (albumArt != null) {
            this.albumArt = albumArt;
        }
    }
}
