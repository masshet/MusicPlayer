package by.mrstark.mp3playerdemo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrstark on 10.2.16.
 */
public class Artist {

    private String name;
    private List<Album> albums;

    public Artist(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Artist) {
            if (name.equals(((Artist) o).getName())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
