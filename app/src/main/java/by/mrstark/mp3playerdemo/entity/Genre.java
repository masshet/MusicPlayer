package by.mrstark.mp3playerdemo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrstark on 4/18/16.
 */
public class Genre {

    private String name;
    private List<Album> albums;

    public Genre(String name) {
        this.name = name;
        albums = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albums.add(album);
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

    @Override
    public boolean equals(Object o) {
        if (o instanceof Genre) {
            if (name.equals(((Genre) o).getName())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
