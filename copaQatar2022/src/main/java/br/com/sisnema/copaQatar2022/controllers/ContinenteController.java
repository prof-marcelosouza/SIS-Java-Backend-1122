package br.com.sisnema.copaQatar2022.controllers;

import br.com.sisnema.copaQatar2022.dtos.ContinenteDto;
import br.com.sisnema.copaQatar2022.services.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/continentes")
public class ContinenteController {

    @Autowired
    private ContinenteService service;

    @GetMapping
    public ResponseEntity<List<ContinenteDto>> buscarTodos() {
        List<ContinenteDto> list = service.procurarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContinenteDto> buscarPorId(@PathVariable Long id) {
        ContinenteDto dto = service.procurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ContinenteDto> inserir(@RequestBody @Valid ContinenteDto dto) {
        dto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContinenteDto> atualizar(@PathVariable Long id, @RequestBody @Valid ContinenteDto dto) {
        dto = service.atualizar(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
