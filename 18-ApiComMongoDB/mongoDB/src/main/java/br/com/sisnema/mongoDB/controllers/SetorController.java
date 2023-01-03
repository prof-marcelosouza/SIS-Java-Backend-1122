package br.com.sisnema.mongoDB.controllers;

import br.com.sisnema.mongoDB.entities.Setor;
import br.com.sisnema.mongoDB.services.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/setores")
public class SetorController {

    @Autowired
    private SetorService service;

    @PostMapping
    public Setor criar(@RequestBody Setor setor) {
        return this.service.criar(setor);
    }

    @GetMapping
    public List<Setor> obterTodos() {
        return this.service.obterTodos();
    }

    @GetMapping(value = "/{codigo}")
    public Setor obterPorCodigo(@PathVariable String codigo) {
        return this.service.obterPorCodigo(codigo);
    }
}
