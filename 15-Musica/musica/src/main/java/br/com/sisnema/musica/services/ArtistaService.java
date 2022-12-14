package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.ArtistaDto;
import br.com.sisnema.musica.entities.*;
import br.com.sisnema.musica.repositories.ArtistaRepository;
import br.com.sisnema.musica.services.exceptions.IntegridadeBD;
import br.com.sisnema.musica.services.exceptions.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository repository;

    @Transactional(readOnly = true)
    public List<ArtistaDto> procurarTodos() {
        List<Artista> list = repository.findAll();
        return list.stream().map(x -> new ArtistaDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ArtistaDto procurarPorId(Long id) {
        Optional<Artista> objeto = repository.findById(id);
        Artista entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("Este ID não existe em nosso sistema.")
        );
        return new ArtistaDto(entidade);
    }

    @Transactional
    public ArtistaDto inserir(ArtistaDto dto) {
        Artista entidade = new Artista();
        entidade.setNome(dto.getNome());
        entidade.setBanda(dto.isBanda());
        entidade.setPais(new Pais(dto.getPais_id()));
        entidade.setEstado(new Estado(dto.getEstado_id()));
        entidade.setCidade(new Cidade(dto.getCidade_id()));
        entidade.setGenero(new Genero(dto.getGenero_id()));
        entidade = repository.save(entidade);
        return new ArtistaDto(entidade);
    }

    @Transactional
    public ArtistaDto atualizar(Long id, ArtistaDto dto) {
        try {
            Artista entidade = repository.getReferenceById(id);
            entidade.setNome(dto.getNome());
            entidade.setBanda(dto.isBanda());
            entidade.setPais(new Pais(dto.getPais_id()));
            entidade.setEstado(new Estado(dto.getEstado_id()));
            entidade.setCidade(new Cidade(dto.getCidade_id()));
            entidade.setGenero(new Genero(dto.getGenero_id()));
            entidade = repository.save(entidade);
            return new ArtistaDto(entidade);
        }
        catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontrado("Id não encontrado: " + id);
        }
    }

    public void excluir(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new RecursoNaoEncontrado("Id não encontrado: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new IntegridadeBD("Violação de integridade no banco de dados.");
        }
    }

}
