package br.com.sisnema.mongoDB.services.impl;

import br.com.sisnema.mongoDB.entities.Funcionario;
import br.com.sisnema.mongoDB.repositories.FuncionarioRepository;
import br.com.sisnema.mongoDB.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public Funcionario criar(Funcionario funcionario) {
        return this.repository.save(funcionario);
    }

    @Override
    public List<Funcionario> obterTodos() {
        return this.repository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
        return this.repository.findById(codigo).orElseThrow(
                () -> new IllegalArgumentException("Funcionário nulo ou inexistente.")
        );
    }
}
