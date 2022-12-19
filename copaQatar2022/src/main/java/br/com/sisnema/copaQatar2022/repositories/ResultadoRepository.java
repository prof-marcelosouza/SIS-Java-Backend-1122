package br.com.sisnema.copaQatar2022.repositories;

import br.com.sisnema.copaQatar2022.entities.Posicao;
import br.com.sisnema.copaQatar2022.entities.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
}
