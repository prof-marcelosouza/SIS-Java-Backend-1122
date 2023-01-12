package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.ArtistaDto;
import br.com.sisnema.musica.dtos.UsuarioDto;
import br.com.sisnema.musica.entities.*;
import br.com.sisnema.musica.repositories.FuncaoRepository;
import br.com.sisnema.musica.repositories.UsuarioRepository;
import br.com.sisnema.musica.services.exceptions.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsuarioService implements UserDetailsService {

    @Autowired // Injeção de dependência
    private UsuarioRepository repository;

    @Autowired // Injeção de dependência
    private FuncaoRepository funcaoRepository;

    @Transactional(readOnly = true)
    public List<UsuarioDto> procurarTodos() {
        List<Usuario> list = repository.findAll();
        return list.stream().map(x -> new UsuarioDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioDto procurarPorId(Long id) {
        Optional<Usuario> objeto = repository.findById(id);
        Usuario entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("Este ID não existe em nosso sistema.")
        );
        return new UsuarioDto(entidade);
    }

    @Transactional
    public UsuarioDto inserir(UsuarioDto dto) {
        Usuario entidade = new Usuario();



        entidade = repository.save(entidade);
        return new UsuarioDto(entidade);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
