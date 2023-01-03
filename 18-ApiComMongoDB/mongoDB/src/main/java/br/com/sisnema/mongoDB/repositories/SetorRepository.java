package br.com.sisnema.mongoDB.repositories;

import br.com.sisnema.mongoDB.entities.Setor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends MongoRepository<Setor, String> {
}
