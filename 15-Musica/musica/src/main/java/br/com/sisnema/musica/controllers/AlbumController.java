package br.com.sisnema.musica.controllers;

import br.com.sisnema.musica.dtos.AlbumDto;
import br.com.sisnema.musica.dtos.ArtistaDto;
import br.com.sisnema.musica.services.AlbumService;
import br.com.sisnema.musica.services.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/albuns")
public class AlbumController {

    @Autowired
    private AlbumService service;

    @GetMapping
    public ResponseEntity<List<AlbumDto>> buscarTodos() {
        List<AlbumDto> list = service.procurarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlbumDto> buscarPorId(@PathVariable Long id) {
        AlbumDto dto = service.procurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<AlbumDto> inserir(@RequestBody AlbumDto dto) {
        dto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AlbumDto> atualizar(@PathVariable Long id, @RequestBody AlbumDto dto) {
        dto = service.atualizar(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
