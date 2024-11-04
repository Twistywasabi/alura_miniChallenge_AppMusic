package br.com.alura.MusicApp.model;

public class Artist {

    private String name;

    private Categoria tipo;

    public Artist(String name, Categoria tipo) {
        this.name = name;
        this.tipo = tipo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Artista: '" + name + '\'' +
                ", Tipo: " + tipo;
    }
}
