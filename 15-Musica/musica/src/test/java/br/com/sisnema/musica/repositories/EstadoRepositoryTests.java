package br.com.sisnema.musica.repositories;

import br.com.sisnema.musica.entities.Estado;
import br.com.sisnema.musica.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class EstadoRepositoryTests {

    @Autowired
    private EstadoRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeEstados;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeEstados = 6L;
    }

    @Test
    public void deleteDeveriaExcluirOObjetoQuandoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Estado> resultado = repository.findById(idExistente);
        Assertions.assertFalse(resultado.isPresent()); // Estado
        // Existe um objeto Estado aqui dentro?
    }

    @Test
    public void deleteDeveriaLancarExcecaoSeOIdENaoxistir() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(idNaoExistente);
        });
    }

    @Test
    public void saveDeveriaPersistirComAutoincrementoQuandoOIdForNulo() {
        Estado estado = Factory.criarEstado(); // 1L, Curitiba
        estado.setId(null); // null, Curitiba
        estado = repository.save(estado); // 7L, Curitiba
        Assertions.assertNotNull(estado.getId()); // 7L
        Assertions.assertEquals(contagemTotalDeEstados + 1, estado.getId());
    }

    // Update não faz sentido na camada de Repository.

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalComUmObjeto() {
        Optional<Estado> resultado = repository.findById(idExistente); // 1L
        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalVazio() {
        Optional<Estado> resultado = repository.findById(idNaoExistente); // 999L
        Assertions.assertTrue(resultado.isEmpty());
    }

}
