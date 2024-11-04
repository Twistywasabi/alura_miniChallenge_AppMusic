package br.com.alura.MusicApp.principal;

import br.com.alura.MusicApp.model.Artist;
import br.com.alura.MusicApp.model.Categoria;
import br.com.alura.MusicApp.model.Music;
import br.com.alura.MusicApp.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner reading = new Scanner(System.in);
    private List<Artist> artistList = new ArrayList<>();
    private List<Music> musicList = new ArrayList<>();
    private ArtistRepository repositorio;

    public Principal(ArtistRepository repositorio) {
        this.repositorio = repositorio;
    }

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
                    listMusic();
                    break;
                case 4:
                    System.out.println("Caso 4");
                    searchMusicsByArtist();
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
            //artistList.add(artist);
            repositorio.save(artist);
            //artistList = repositorio.findAll();

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: categoria inválida, digite com letras maiúsculas");
            System.out.println(e);
        }
    }

    private void addMusic() {
        System.out.println(artistList);
        System.out.println("De qual artista você quer adicionar uma música ?");
        var addedArtistMusic = reading.nextLine();
        artistList.forEach(a -> {

            boolean isArtistPresent = a.getName().contains(addedArtistMusic);
            if (isArtistPresent) {
                System.out.println("Nome da música");
                var addMusic = reading.nextLine();
                System.out.println("Nome do álbum");
                var addMusicAlbum = reading.nextLine();
                Music selectedMusic = new Music(addMusic, addMusicAlbum, a);
                musicList.add(selectedMusic);
                System.out.println("Música adicionada");
                System.out.println(musicList);

            }

        });
    }

    private void listMusic() {

        artistList = repositorio.findAll();
    }

    private void searchMusicsByArtist() {
        System.out.println("Digite o artista: ");
        var searchArtist = reading.nextLine();
        List<Music> selectedMusic = new ArrayList<>();
        musicList.forEach(m -> {

            boolean isMusicFromArtist = m.getArtist().getName().contains(searchArtist);

            if(isMusicFromArtist) {
               selectedMusic.add(m);
            }

        });
        System.out.println(selectedMusic);

    }

}
