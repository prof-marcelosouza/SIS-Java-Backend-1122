package br.com.sisnema.musica.controllers;

import br.com.sisnema.musica.dtos.PaisDto;
import br.com.sisnema.musica.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {

    @Autowired
    private PaisService service;

    // Listar todos os países
    @GetMapping
    public ResponseEntity<List<PaisDto>> buscarTodos() {
        List<PaisDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // Listar um país por ID

    // Cadastrar um país

    // Atualizar um país

    // Deletar um país

}
