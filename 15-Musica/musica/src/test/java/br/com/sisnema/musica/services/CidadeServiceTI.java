package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.CidadeDto;
import br.com.sisnema.musica.repositories.CidadeRepository;
import br.com.sisnema.musica.services.exceptions.RecursoNaoEncontrado;
import br.com.sisnema.musica.tests.Factory;
import br.com.sisnema.musica.tests.FactoryFK;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class CidadeServiceTI {

    @Autowired
    private CidadeService service;

    @Autowired
    private CidadeRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private Long contagemTotalDeCidadees;
    private CidadeDto cidadeDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 7L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 1L;
        contagemTotalDeCidadees = 7L;
        cidadeDto = Factory.criarCidadeDto();
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeDtos() {
        List<CidadeDto> lista = service.procurarTodos();
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmDtoQuandoOIdExistir() {
        CidadeDto resultado = service.procurarPorId(idExistente);
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
        CidadeDto resultado = service.inserir(cidadeDto); // Retorna - 6L Uruguai
        Assertions.assertEquals(contagemTotalDeCidadees + 1, repository.count());
//        System.out.println("Quantidade de registros em Cidade: " + repository.count());
//        System.out.println("Registro inserido em Cidade: " + resultado);
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        CidadeDto resultado = service.atualizar(idExistente, cidadeDto);
        Assertions.assertNotNull(resultado);
//        System.out.println("Registro inserido em Cidade: " + resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
           service.atualizar(idNaoExistente, cidadeDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmRegistro() {
        service.excluir(idExistente);
        Assertions.assertEquals(contagemTotalDeCidadees - 1, repository.count());
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
