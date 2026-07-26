package br.com.cauesobral.screensound.repository;

import br.com.cauesobral.screensound.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
