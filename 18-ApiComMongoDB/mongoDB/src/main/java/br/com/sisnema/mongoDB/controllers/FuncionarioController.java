package br.com.sisnema.mongoDB.controllers;

import br.com.sisnema.mongoDB.entities.Funcionario;
import br.com.sisnema.mongoDB.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return this.service.criar(funcionario);
    }

    @GetMapping
    public List<Funcionario> obterTodos() {
        return this.service.obterTodos();
    }

    @GetMapping(value = "/{codigo}")
    public Funcionario obterPorCodigo(@PathVariable String codigo) {
        return this.service.obterPorCodigo(codigo);
    }
}
