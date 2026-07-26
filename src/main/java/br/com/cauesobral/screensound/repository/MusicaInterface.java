package br.com.cauesobral.screensound.repository;

import br.com.cauesobral.screensound.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaInterface extends JpaRepository <Musica, Long> {
}
