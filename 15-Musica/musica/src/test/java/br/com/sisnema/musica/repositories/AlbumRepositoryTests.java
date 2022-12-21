package br.com.sisnema.musica.repositories;

import br.com.sisnema.musica.entities.Album;
import br.com.sisnema.musica.entities.Cidade;
import br.com.sisnema.musica.tests.Factory;
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
public class AlbumRepositoryTests {

    @Autowired
    private AlbumRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeAlbuns;
    private List<Album> albumList = new ArrayList<>();

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeAlbuns = 39L;
    }

    @Test
    public void saveDeveriaPersistirComAutoincrementoQuandoOIdForNulo() {
        Album album = FactoryFK.criarAlbum();
        album.setId(null);
        album = repository.save(album);
        Assertions.assertNotNull(album.getId());
        Assertions.assertEquals(contagemTotalDeAlbuns + 1, album.getId());
    }

    // Update não faz sentido na camada de Repository.

    @Test
    public void findAllDeveriaRetornarUmaListaDeObjetos() {
        albumList = repository.findAll();
        Assertions.assertNotNull(albumList);
    }

    @Test
    public void findByIdDeveriaRetornarUmOptionalComUmObjeto() {
        Optional<Album> resultado = repository.findById(idExistente); // 1L
        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void findByIdDeveriaRetornarUmOptionalVazio() {
        Optional<Album> resultado = repository.findById(idNaoExistente); // 999L
        Assertions.assertTrue(resultado.isEmpty());
    }

    @Test
    public void deleteByIdDeveriaExcluirOObjetoQuandoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Album> resultado = repository.findById(idExistente);
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
