package br.com.sisnema.musica.controllers;

import br.com.sisnema.musica.dtos.CidadeDto;
import br.com.sisnema.musica.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping
    public ResponseEntity<List<CidadeDto>> buscarTodos() {
        List<CidadeDto> list = service.procurarTodos();
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<CidadeDto> buscarPorId(@PathVariable Long id) {
        CidadeDto dto = service.procurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }
    
    @PostMapping
    public ResponseEntity<CidadeDto> inserir(@RequestBody CidadeDto dto) {
        dto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<CidadeDto> atualizar(@PathVariable Long id, @RequestBody CidadeDto dto) {
        dto = service.atualizar(id, dto);
        return ResponseEntity.ok().body(dto);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
