package br.com.cauesobral.screensound.repository;

import br.com.cauesobral.screensound.model.Banda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandaInterface extends JpaRepository <Banda, Long> {
}
