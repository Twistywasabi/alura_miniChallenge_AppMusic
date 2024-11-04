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

    @Override
    public String toString() {
        return "Music{" +
                "musicName='" + musicName + '\'' +
                ", album='" + album + '\'' +
                ", artist=" + artist.getName() +
                '}';
    }
}
