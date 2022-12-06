package br.com.sisnema.musica.controllers;

import br.com.sisnema.musica.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {

    @Autowired
    private PaisService service;

    // Listar todos os países


    // Listar um país por ID

    // Cadastrar um país

    // Atualizar um país

    // Deletar um país

}
