package br.com.sisnema.musica.repositories;

import br.com.sisnema.musica.entities.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncaoRepository extends JpaRepository<Funcao, Long> {
}
