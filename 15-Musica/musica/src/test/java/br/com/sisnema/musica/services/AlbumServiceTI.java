package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.AlbumDto;
import br.com.sisnema.musica.repositories.AlbumRepository;
import br.com.sisnema.musica.services.exceptions.RecursoNaoEncontrado;
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
public class AlbumServiceTI {

    @Autowired
    private AlbumService service;

    @Autowired
    private AlbumRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private Long contagemTotalDeAlbumes;
    private AlbumDto albumDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 2L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 1L;
        contagemTotalDeAlbumes = 39L;
        albumDto = FactoryFK.criarAlbumDto();
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeDtos() {
        List<AlbumDto> lista = service.procurarTodos();
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmDtoQuandoOIdExistir() {
        AlbumDto resultado = service.procurarPorId(idExistente);
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
        AlbumDto resultado = service.inserir(albumDto); // Retorna - 6L Uruguai
        Assertions.assertEquals(contagemTotalDeAlbumes + 1, repository.count());
//        System.out.println("Quantidade de registros em Album: " + repository.count());
//        System.out.println("Registro inserido em Album: " + resultado);
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        AlbumDto resultado = service.atualizar(idExistente, albumDto);
        Assertions.assertNotNull(resultado);
//        System.out.println("Registro inserido em Album: " + resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
           service.atualizar(idNaoExistente, albumDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmRegistro() {
        service.excluir(idExistente);
        Assertions.assertEquals(contagemTotalDeAlbumes - 1, repository.count());
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
