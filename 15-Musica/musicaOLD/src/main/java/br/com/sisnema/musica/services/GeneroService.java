package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.GeneroDto;
import br.com.sisnema.musica.entities.Genero;
import br.com.sisnema.musica.repositories.GeneroRepository;
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
public class GeneroService {

    @Autowired
    private GeneroRepository repository;

    @Transactional(readOnly = true)
    public List<GeneroDto> procurarTodos() {
        List<Genero> list = repository.findAll();
        return list.stream().map(x -> new GeneroDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GeneroDto procurarPorId(Long id) {
        Optional<Genero> objeto = repository.findById(id);
        Genero entidade = objeto.orElseThrow(() ->
                    new RecursoNaoEncontrado("Este ID não existe em nosso sistema.")
                );
        return new GeneroDto(entidade);
    }

    @Transactional
    public GeneroDto inserir(GeneroDto dto) {
        Genero entidade = new Genero();
        entidade.setNome(dto.getNome());
        entidade = repository.save(entidade);
        return new GeneroDto(entidade);
    }
    
    @Transactional
    public GeneroDto atualizar(Long id, GeneroDto dto) {
        try {
            Genero entidade = repository.getReferenceById(id);
            entidade.setNome(dto.getNome());
            entidade = repository.save(entidade);
            return new GeneroDto(entidade);
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
