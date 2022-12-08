package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.PaisDto;
import br.com.sisnema.musica.entities.Pais;
import br.com.sisnema.musica.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaisService {

    @Autowired // Injeção de dependência
    private PaisRepository repository;

    // Listar todos os países
    @Transactional(readOnly = true)
    public List<PaisDto> procurarTodos() {
        List<Pais> list = repository.findAll();
        // Expressão Lambda ou Alta ordem
        return list.stream().map(x -> new PaisDto(x)).collect(Collectors.toList());
    } // Retorna uma lista de PaisDto para o Controller

//    @Transactional(readOnly = true)
//    public List<Pais> findAll() {
//        List<Pais> list = repository.findAll();
//        return list;
//    }

    // Listar um país por ID
    @Transactional(readOnly = true)
    public PaisDto procurarPorId(Long id) {
        Optional<Pais> objeto = repository.findById(id); //5 Blues
        Pais entidade = objeto.get();
        return new PaisDto(entidade);
    }

    // Cadastrar um país
    @Transactional
    public PaisDto inserir(PaisDto dto) {
        Pais entidade = new Pais(); // null null
        entidade.setNome(dto.getNome()); // null Rússia
        entidade = repository.save(entidade); // null Rússia
        // E retorna 6 Rússia
        return new PaisDto(entidade);
    }

    // Atualizar um país
    @Transactional
    public PaisDto atualizar(Long id, PaisDto dto) {
        Pais entidade = repository.getReferenceById(id); // 6
        entidade.setNome(dto.getNome()); // Rússia
        entidade = repository.save(entidade); // 6 Rússia
        return new PaisDto(entidade);
    }

    // Deletar um país

}
