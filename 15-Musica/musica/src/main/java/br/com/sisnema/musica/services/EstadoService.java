package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.EstadoDto;
import br.com.sisnema.musica.entities.Estado;
import br.com.sisnema.musica.repositories.EstadoRepository;
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
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    @Transactional(readOnly = true)
    public List<EstadoDto> procurarTodos() {
        List<Estado> list = repository.findAll();
        return list.stream().map(x -> new EstadoDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EstadoDto procurarPorId(Long id) {
        Optional<Estado> objeto = repository.findById(id);
        Estado entidade = objeto.orElseThrow(() ->
                    new RecursoNaoEncontrado("Este ID não existe em nosso sistema.")
                );
        return new EstadoDto(entidade);
    }

    @Transactional
    public EstadoDto inserir(EstadoDto dto) {
        Estado entidade = new Estado();
        entidade.setNome(dto.getNome());
        entidade = repository.save(entidade);
        return new EstadoDto(entidade);
    }

    @Transactional
    public EstadoDto atualizar(Long id, EstadoDto dto) {
        try {
            Estado entidade = repository.getReferenceById(id);
            entidade.setNome(dto.getNome());
            entidade = repository.save(entidade);
            return new EstadoDto(entidade);
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
