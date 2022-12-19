package br.com.sisnema.copaQatar2022.repositories;

import br.com.sisnema.copaQatar2022.entities.Continente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinenteRepository extends JpaRepository<Continente, Long> {
}
