package br.com.alura.MusicApp.model;

public class Music {

    private String musicName;

    private String album;

    private Artist artist;

    public Music(String musicName, String album, Artist artist) {
        this.musicName = musicName;
        this.album = album;
        this.artist = artist;
    }

    public Artist getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Música: '" + musicName + '\'' +
                ", Álbum: '" + album + '\'' +
                ", Artista: '" + artist.getName() + '\'';
    }
}
