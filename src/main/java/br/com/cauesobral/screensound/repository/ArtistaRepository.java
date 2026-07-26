package br.com.cauesobral.screensound.repository;

import br.com.cauesobral.screensound.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNomeIgnoreCase(String nome);
}
