package br.com.sisnema.musica.repositories;

import br.com.sisnema.musica.entities.Artista;
import br.com.sisnema.musica.tests.FactoryFK;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class ArtistaRepositoryTests {

    @Autowired
    private ArtistaRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeArtistas;
    private List<Artista> artistaList = new ArrayList<>();

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeArtistas = 3L;
    }

    @Test
    public void saveDeveriaPersistirComAutoincrementoQuandoOIdForNulo() {
        Artista artista = FactoryFK.criarArtista();
        artista.setId(null);
        artista = repository.save(artista);
        Assertions.assertNotNull(artista.getId());
        Assertions.assertEquals(contagemTotalDeArtistas + 1, artista.getId());
    }

    // Update não faz sentido na camada de Repository.

    @Test
    public void findAllDeveriaRetornarUmaListaDeObjetos() {
        artistaList = repository.findAll();
        Assertions.assertNotNull(artistaList);
    }

    @Test
    public void findByIdDeveriaRetornarUmOptionalComUmObjeto() {
        Optional<Artista> resultado = repository.findById(idExistente); // 1L
        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void findByIdDeveriaRetornarUmOptionalVazio() {
        Optional<Artista> resultado = repository.findById(idNaoExistente); // 999L
        Assertions.assertTrue(resultado.isEmpty());
    }

    @Test
    public void deleteByIdDeveriaExcluirOObjetoQuandoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Artista> resultado = repository.findById(idExistente);
        Assertions.assertFalse(resultado.isPresent()); // Cidade
        // Existe um objeto cidade aqui dentro?
    }

    @Test
    public void deleteByIdDeveriaLancarExcecaoSeOIdENaoxistir() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(idNaoExistente);
        });
    }
}
