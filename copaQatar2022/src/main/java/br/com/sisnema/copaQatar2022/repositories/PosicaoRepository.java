package br.com.sisnema.copaQatar2022.repositories;

import br.com.sisnema.copaQatar2022.entities.Posicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosicaoRepository extends JpaRepository<Posicao, Long> {
}
