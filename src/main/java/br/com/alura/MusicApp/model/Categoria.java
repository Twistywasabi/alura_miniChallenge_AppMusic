package br.com.alura.MusicApp.model;

public enum Categoria {

    SOLO("solo"),
    DUPLA("dupla"),
    BANDA("banda");

    private String tipo;

    Categoria(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo(){
        return this.tipo;
    }

}
