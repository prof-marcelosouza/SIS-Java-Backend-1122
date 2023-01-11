package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.CidadeDto;
import br.com.sisnema.musica.entities.Cidade;
import br.com.sisnema.musica.repositories.CidadeRepository;
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
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    @Transactional(readOnly = true)
    public List<CidadeDto> procurarTodos() {
        List<Cidade> list = repository.findAll();
        return list.stream().map(x -> new CidadeDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CidadeDto procurarPorId(Long id) {
        Optional<Cidade> objeto = repository.findById(id);
        Cidade entidade = objeto.orElseThrow(() ->
                    new RecursoNaoEncontrado("Este ID não existe em nosso sistema.")
                );
        return new CidadeDto(entidade);
    }

    @Transactional
    public CidadeDto inserir(CidadeDto dto) {
        Cidade entidade = new Cidade();
        entidade.setNome(dto.getNome());
        entidade = repository.save(entidade);
        return new CidadeDto(entidade);
    }
    
    @Transactional
    public CidadeDto atualizar(Long id, CidadeDto dto) {
        try {
            Cidade entidade = repository.getReferenceById(id);
            entidade.setNome(dto.getNome());
            entidade = repository.save(entidade);
            return new CidadeDto(entidade);
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
