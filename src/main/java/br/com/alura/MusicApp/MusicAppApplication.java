package br.com.alura.MusicApp;

import br.com.alura.MusicApp.principal.Principal;
import br.com.alura.MusicApp.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class MusicAppApplication implements CommandLineRunner {

	@Autowired
	private ArtistRepository repositorio;


	public static void main(String[] args) {
		SpringApplication.run(MusicAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.showMenu();
	}
}
