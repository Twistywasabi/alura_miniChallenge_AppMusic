package br.com.alura.MusicApp.principal;

import br.com.alura.MusicApp.model.Artist;
import br.com.alura.MusicApp.model.Categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner reading = new Scanner(System.in);
    private List<Artist> artistList = new ArrayList<>();

    public void showMenu(){

        var options = -1;

        while(options != 9){

            String menu = """
				
				*** Screen Sound Músicas ***
				
				1 - Cadastrar artistas
				2 - Cadastrar músicas
				3 - Listar Músicas
				4 - Buscar músicas por artistas
				5 - Pesquisar dados sobre um artista
				
				9 - Sair
				
				""";

            System.out.println(menu);
            options = reading.nextInt();
            reading.nextLine();

            switch (options) {
                case 1:
                    System.out.println("Caso 1");
                    addArtist();
                    break;
                case 2:
                    System.out.println("Caso 2");
                    addMusic();
                    break;
                case 3:
                    System.out.println("Caso 3");
                    break;
                case 4:
                    System.out.println("Caso 4");
                    break;
                case 5:
                    System.out.println("Caso 5");
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }


        }

    }



    private void addArtist(){
        System.out.println("Adicione um Artista: ");
        var addedArtist = reading.nextLine();
        System.out.println("Adicione o tipo do artista (SOLO, DUPLA, BANDA): ");
        try {

        var addedArtistType = reading.nextLine();
        Categoria typeArtist = Categoria.valueOf(addedArtistType);
        Artist artist = new Artist(addedArtist, typeArtist);
        artistList.add(artist);
        System.out.println(artistList);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: categoria inválida, digite com letras maiúsculas");
            System.out.println(e);
        }
    }

    private void addMusic() {
        System.out.println(artistList);
        System.out.println("De qual artista você quer adicionar uma música ?");
        var addedArtistMusic = reading.nextLine();
        artistList.forEach(a -> System.out.println(a.getName().contains(addedArtistMusic)));
    }

}
