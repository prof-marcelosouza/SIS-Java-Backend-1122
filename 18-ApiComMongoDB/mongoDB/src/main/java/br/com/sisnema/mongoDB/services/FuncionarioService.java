package br.com.sisnema.mongoDB.services;

import br.com.sisnema.mongoDB.entities.Funcionario;

import java.util.List;

public interface FuncionarioService {

    Funcionario criar(Funcionario funcionario);
    List<Funcionario> obterTodos();
    Funcionario obterPorCodigo(String codigo);

}
