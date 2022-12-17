package br.com.sisnema.musica.controllers;

import br.com.sisnema.musica.dtos.PaisDto;
import br.com.sisnema.musica.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {

    @Autowired
    private PaisService service;

    // Listar todos os países
    @GetMapping
    public ResponseEntity<List<PaisDto>> buscarTodos() {
        List<PaisDto> list = service.procurarTodos();
        return ResponseEntity.ok().body(list);
    }

//    @GetMapping
//    public ResponseEntity<List<Pais>> buscarTodos() {
//        List<Pais> list = service.procurarTodos();
//        return ResponseEntity.ok().body(list);
//    }

    // Listar um país por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<PaisDto> buscarPorId(@PathVariable Long id) {
        PaisDto dto = service.procurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    // Cadastrar um país
    @PostMapping
    public ResponseEntity<PaisDto> inserir(@RequestBody @Valid PaisDto dto) {
        dto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    // Atualizar um país
    @PutMapping(value = "/{id}")
    public ResponseEntity<PaisDto> atualizar(@PathVariable Long id, @RequestBody @Valid PaisDto dto) {
        dto = service.atualizar(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    // Deletar um país
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
