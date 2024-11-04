package br.com.alura.MusicApp.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
    @Table(name = "artistas")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Nome_Artistico", unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Categoria tipo;

    @Transient
    private List<Music> musicas = new ArrayList<>();


    public Artist() {}

    public Artist(String name, Categoria tipo) {
        this.name = name;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Music> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Music> musicas) {
        this.musicas = musicas;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Artista: '" + name + '\'' +
                ", Tipo: " + tipo + '\n';
    }
}
