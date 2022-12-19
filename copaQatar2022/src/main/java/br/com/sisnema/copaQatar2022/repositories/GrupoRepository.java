package br.com.sisnema.copaQatar2022.repositories;

import br.com.sisnema.copaQatar2022.entities.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
}
