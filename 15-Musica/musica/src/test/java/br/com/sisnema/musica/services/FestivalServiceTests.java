package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.FestivalDto;
import br.com.sisnema.musica.entities.Festival;
import br.com.sisnema.musica.repositories.FestivalRepository;
import br.com.sisnema.musica.services.exceptions.IntegridadeBD;
import br.com.sisnema.musica.services.exceptions.RecursoNaoEncontrado;
import br.com.sisnema.musica.tests.FactoryFK;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
public class FestivalServiceTests {

    @InjectMocks
    private FestivalService service;

    @Mock
    private FestivalRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private Long contagemTotalDeAlbuns;
    private Festival festival;
    private FestivalDto festivalDto;
    private List<Festival> festivalList;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 2L;
        contagemTotalDeAlbuns = 8L;
        festival = FactoryFK.criarFestival();
        festivalDto = FactoryFK.criarFestivalDto();
        festivalList = new ArrayList<>();

        // Simulações da camada de repository;
        Mockito.when(repository.findAll()).thenReturn(festivalList);

        Mockito.when(repository.findById(idExistente)).thenReturn(Optional.of(festival));
        Mockito.when(repository.findById(idNaoExistente)).thenReturn(Optional.empty());

        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(festival);

        Mockito.when(repository.getReferenceById(idExistente)).thenReturn(festival);
        Mockito.when(repository.getReferenceById(idNaoExistente)).thenThrow(EntityNotFoundException.class);

        Mockito.doNothing().when(repository).deleteById(idExistente);
        Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(idNaoExistente);
        Mockito.doThrow(DataIntegrityViolationException.class).when(repository).deleteById(idChaveEstrangeira);
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeObjetos() {
        List<FestivalDto> list = service.procurarTodos();
        Assertions.assertNotNull(list);
        Mockito.verify(repository, times(1)).findAll();
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmProdutoQuandoOIdExistir() {
        FestivalDto resultado = service.procurarPorId(idExistente);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmaExcecaoQuandoOIdNaoExistir() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.procurarPorId(idNaoExistente);
        });
        Mockito.verify(repository, times(1)).findById(idNaoExistente);
    }

    @Test
    public void inserirDeveriaGravarUmObjetoNoBancoDeDados() {
        FestivalDto resultado = service.inserir(festivalDto);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        FestivalDto resultado = service.atualizar(idExistente, festivalDto);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoQuandoOIdNaoExistir() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, festivalDto);
        });
    }

    @Test
    public void excluirDeveriaDeletarUmObjeto() {
        Assertions.assertDoesNotThrow(() -> {
            service.excluir(idExistente);
        });
    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });
        Mockito.verify(repository, times(1)).deleteById(idNaoExistente);
    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIntegridadeDeBancoDeDados() {
        Assertions.assertThrows(IntegridadeBD.class, () -> {
            service.excluir(idChaveEstrangeira);
        });
        Mockito.verify(repository, times(1)).deleteById(idChaveEstrangeira);
    }
}
