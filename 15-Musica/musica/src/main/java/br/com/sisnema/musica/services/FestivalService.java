package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.ArtistaDto;
import br.com.sisnema.musica.dtos.FestivalDto;
import br.com.sisnema.musica.entities.*;
import br.com.sisnema.musica.repositories.ArtistaRepository;
import br.com.sisnema.musica.repositories.FestivalRepository;
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
public class FestivalService {

    @Autowired
    private FestivalRepository repository;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Transactional(readOnly = true)
    public List<FestivalDto> procurarTodos() {
        List<Festival> list = repository.findAll();
        return list.stream().map(x -> new FestivalDto(x, x.getArtistas())).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FestivalDto procurarPorId(Long id) {
        Optional<Festival> objeto = repository.findById(id);
        Festival entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("Este ID não existe em nosso sistema.")
        );
        return new FestivalDto(entidade, entidade.getArtistas());
    }

    @Transactional
    public FestivalDto inserir(FestivalDto dto) {
        Festival entidade = new Festival();
        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);
        return new FestivalDto(entidade);
    }

    @Transactional
    public FestivalDto atualizar(Long id, FestivalDto dto) {
        try {
            Festival entidade = repository.getReferenceById(id);
            copiarDtoParaEntidade(dto, entidade);
            entidade = repository.save(entidade);
            return new FestivalDto(entidade);
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

    private void copiarDtoParaEntidade(FestivalDto dto, Festival entidade) {
        entidade.setNome(dto.getNome());
        entidade.setDataEvento(dto.getDataEvento());

        entidade.getArtistas().clear();
        for (ArtistaDto artDto : dto.getArtistas()) { // 0 1 3
            Artista artista = artistaRepository.getReferenceById(artDto.getId());
            entidade.getArtistas().add(artista);
        }
    }

}
