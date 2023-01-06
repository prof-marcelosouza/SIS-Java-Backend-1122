package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.EstadoDto;
import br.com.sisnema.musica.repositories.EstadoRepository;
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
public class EstadoServiceTI {

    @Autowired
    private EstadoService service;

    @Autowired
    private EstadoRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private Long contagemTotalDeEstados;
    private EstadoDto estadoDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 7L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 1L;
        contagemTotalDeEstados = 7L;
        estadoDto = Factory.criarEstadoDto();
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeDtos() {
        List<EstadoDto> lista = service.procurarTodos();
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmDtoQuandoOIdExistir() {
        EstadoDto resultado = service.procurarPorId(idExistente);
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
        EstadoDto resultado = service.inserir(estadoDto); // Retorna - 6L Uruguai
        Assertions.assertEquals(contagemTotalDeEstados + 1, repository.count());
//        System.out.println("Quantidade de registros em Estado: " + repository.count());
//        System.out.println("Registro inserido em Estado: " + resultado);
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        EstadoDto resultado = service.atualizar(idExistente, estadoDto);
        Assertions.assertNotNull(resultado);
//        System.out.println("Registro inserido em Estado: " + resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
           service.atualizar(idNaoExistente, estadoDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmRegistro() {
        service.excluir(idExistente);
        Assertions.assertEquals(contagemTotalDeEstados - 1, repository.count());
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
