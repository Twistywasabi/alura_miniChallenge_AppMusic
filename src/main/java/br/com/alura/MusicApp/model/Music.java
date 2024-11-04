package br.com.alura.MusicApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")

public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String musicName;

    private String album;

    @ManyToOne
    private Artist artist;

    public Music(String musicName, String album, Artist artist) {
        this.musicName = musicName;
        this.album = album;
        this.artist = artist;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Música: '" + musicName + '\'' +
                ", Álbum: '" + album + '\'' +
                ", Artista: '" + artist.getName() + '\'' + '\n';
    }
}
