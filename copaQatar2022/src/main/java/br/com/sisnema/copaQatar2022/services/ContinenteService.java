package br.com.sisnema.copaQatar2022.services;

import br.com.sisnema.copaQatar2022.dtos.ContinenteDto;
import br.com.sisnema.copaQatar2022.entities.Continente;
import br.com.sisnema.copaQatar2022.repositories.ContinenteRepository;
import br.com.sisnema.copaQatar2022.services.exceptions.IntegridadeBD;
import br.com.sisnema.copaQatar2022.services.exceptions.RecursoNaoEncontrado;
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
public class ContinenteService {

    @Autowired
    private ContinenteRepository repository;

    @Transactional(readOnly = true)
    public List<ContinenteDto> procurarTodos() {
        List<Continente> list = repository.findAll();
        return list.stream().map(x -> new ContinenteDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ContinenteDto procurarPorId(Long id) {
        Optional<Continente> objeto = repository.findById(id);
        Continente entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("Este ID não existe em nosso sistema.")
        );
        return new ContinenteDto(entidade);
    }

    @Transactional
    public ContinenteDto inserir(ContinenteDto dto) {
        Continente entidade = new Continente();
        entidade.setNome(dto.getNome());
        entidade = repository.save(entidade);
        return new ContinenteDto(entidade);
    }

    @Transactional
    public ContinenteDto atualizar(Long id, ContinenteDto dto) {
        try {
            Continente entidade = repository.getReferenceById(id);
            entidade.setNome(dto.getNome());
            entidade = repository.save(entidade);
            return new ContinenteDto(entidade);
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
