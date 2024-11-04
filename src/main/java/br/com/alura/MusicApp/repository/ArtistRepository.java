package br.com.alura.MusicApp.repository;

import br.com.alura.MusicApp.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
