package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.PaisDto;
import br.com.sisnema.musica.entities.Pais;
import br.com.sisnema.musica.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisService {

    @Autowired // Injeção de dependência
    private PaisRepository repository;

    // Listar todos os países
    @Transactional(readOnly = true)
    public List<PaisDto> findAll() {
        List<Pais> list = repository.findAll();
        return list.stream().map(x -> new PaisDto(x)).collect(Collectors.toList());
    }

    // Listar um país por ID

    // Cadastrar um país

    // Atualizar um país

    // Deletar um país

}
