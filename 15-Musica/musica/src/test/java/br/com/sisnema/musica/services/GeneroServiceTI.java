package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.GeneroDto;
import br.com.sisnema.musica.repositories.GeneroRepository;
import br.com.sisnema.musica.services.exceptions.RecursoNaoEncontrado;
import br.com.sisnema.musica.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class GeneroServiceTI {

    @Autowired
    private GeneroService service;

    @Autowired
    private GeneroRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private Long contagemTotalDeGeneros;
    private GeneroDto festivalDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 5L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 1L;
        contagemTotalDeGeneros = 9L;
        festivalDto = Factory.criarGeneroDto();
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeDtos() {
        List<GeneroDto> lista = service.procurarTodos();
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmDtoQuandoOIdExistir() {
        GeneroDto resultado = service.procurarPorId(idExistente);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmaExcecaoQuandoOIdNaoExistir() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.procurarPorId(idNaoExistente);
        });
    }

    @Test
    public void inserirDeveriaGravarUmObjetoNoBancoDeDados() {
        GeneroDto resultado = service.inserir(festivalDto); // Retorna - 6L Uruguai
        Assertions.assertEquals(contagemTotalDeGeneros + 1, repository.count());
//        System.out.println("Quantidade de registros em Genero: " + repository.count());
//        System.out.println("Registro inserido em Genero: " + resultado);
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        GeneroDto resultado = service.atualizar(idExistente, festivalDto);
        Assertions.assertNotNull(resultado);
//        System.out.println("Registro inserido em Genero: " + resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
           service.atualizar(idNaoExistente, festivalDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmRegistro() {
        service.excluir(idExistente);
        Assertions.assertEquals(contagemTotalDeGeneros - 1, repository.count());
    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });
    }

//    @Test
//    public void excluirDeveriaLancarUmaExcecaoDeIntegridade() {
//        Assertions.assertThrows(IntegridadeBD.class, () -> {
//            service.excluir(idChaveEstrangeira);
//        });
//    }
}
