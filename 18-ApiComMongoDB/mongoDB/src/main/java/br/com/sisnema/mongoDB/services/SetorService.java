package br.com.sisnema.mongoDB.services;

import br.com.sisnema.mongoDB.entities.Setor;

import java.util.List;

public interface SetorService {

    Setor criar(Setor setor);
    List<Setor> obterTodos();
    Setor obterPorCodigo(String codigo);

}
