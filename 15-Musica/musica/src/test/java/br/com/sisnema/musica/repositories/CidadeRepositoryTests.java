package br.com.sisnema.musica.repositories;

import br.com.sisnema.musica.entities.Cidade;

import br.com.sisnema.musica.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class CidadeRepositoryTests {

    @Autowired
    private CidadeRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeCidades;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeCidades = 6L;
    }

    @Test
    public void deleteDeveriaExcluirOObjetoQuandoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Cidade> resultado = repository.findById(idExistente);
        Assertions.assertFalse(resultado.isPresent()); // Cidade
        // Existe um objeto cidade aqui dentro?
    }

    @Test
    public void deleteDeveriaLancarExcecaoSeOIdENaoxistir() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(idNaoExistente);
        });
    }

    @Test
    public void saveDeveriaPersistirComAutoincrementoQuandoOIdForNulo() {
        Cidade cidade = Factory.criarCidade(); // 1L, Curitiba
        cidade.setId(null); // null, Curitiba
        cidade = repository.save(cidade); // 7L, Curitiba
        Assertions.assertNotNull(cidade.getId()); // 7L
        Assertions.assertEquals(contagemTotalDeCidades + 1, cidade.getId());
    }

    // Update não faz sentido na camada de Repository.

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalComUmObjeto() {
        Optional<Cidade> resultado = repository.findById(idExistente); // 1L
        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalVazio() {
        Optional<Cidade> resultado = repository.findById(idNaoExistente); // 999L
        Assertions.assertTrue(resultado.isEmpty());
    }

}
