package br.com.sisnema.mongoDB.repositories;

import br.com.sisnema.mongoDB.entities.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
}
