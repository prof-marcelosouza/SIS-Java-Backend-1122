package br.com.sisnema.musica.controllers;

import br.com.sisnema.musica.dtos.AlbumDto;
import br.com.sisnema.musica.services.AlbumService;
import br.com.sisnema.musica.services.exceptions.RecursoNaoEncontrado;
import br.com.sisnema.musica.tests.FactoryFK;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlbumController.class)
public class AlbumControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlbumService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private AlbumDto albumDto;
    private List<AlbumDto> albumDtoList;

    @BeforeEach
    void setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 2L;
        idChaveEstrangeira = 3L;
        albumDto = FactoryFK.criarAlbumDto();
        albumDtoList = new ArrayList<>();

        when(service.procurarTodos()).thenReturn(albumDtoList);

        when(service.procurarPorId(idExistente)).thenReturn(albumDto);
        when(service.procurarPorId(idNaoExistente)).
                thenThrow(RecursoNaoEncontrado.class);

        when(service.inserir(any())).thenReturn(albumDto);

        when(service.atualizar(eq(idExistente), any())).thenReturn(albumDto);
        when(service.atualizar(eq(idNaoExistente), any()))
                .thenThrow(RecursoNaoEncontrado.class);

        doNothing().when(service).excluir(idExistente);
        doThrow(RecursoNaoEncontrado.class).when(service).excluir(idNaoExistente);
    }

    @Test
    public void inserirDeveriaRetornarUm201Dto() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(albumDto);

        ResultActions resultado = mockMvc.perform(post("/albuns")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isCreated());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.titulo").exists());
        resultado.andExpect(jsonPath("$.ano").exists());
        resultado.andExpect(jsonPath("$.artista_id").exists());
        resultado.andExpect(jsonPath("$.genero_id").exists());
    }

    @Test
    public void procurarTodosDeveriaRetonarUmaLista() throws Exception {

        ResultActions resultado = mockMvc.perform(get("/albuns")
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUm200QuandoOIdExistir() throws Exception {

        ResultActions resultado = mockMvc.perform(get("/albuns/{id}", idExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.titulo").exists());
        resultado.andExpect(jsonPath("$.ano").exists());
        resultado.andExpect(jsonPath("$.artista_id").exists());
        resultado.andExpect(jsonPath("$.genero_id").exists());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {

        ResultActions resultado = mockMvc.perform(get("/albuns/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNotFound());
    }

    @Test
    public void atualizarDeveriaRetornarUm200DtoQuandoOIdExistir() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(albumDto);

        ResultActions resultado = mockMvc.perform(put("/albuns/{id}", idExistente)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.titulo").exists());
        resultado.andExpect(jsonPath("$.ano").exists());
        resultado.andExpect(jsonPath("$.artista_id").exists());
        resultado.andExpect(jsonPath("$.genero_id").exists());
    }

    @Test
    public void atualizarDeveriaRetornarUm404DtoQuandoOIdNaoExistir() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(albumDto);

        ResultActions resultado = mockMvc.perform(put("/albuns/{id}", idNaoExistente)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNotFound());
    }

    @Test
    public void excluirDeveriaRetornarUm204QuandoOIdExistir() throws Exception {

        ResultActions resultado = mockMvc.perform(delete("/albuns/{id}", idExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNoContent());
    }

    @Test
    public void excluirDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {

        ResultActions resultado = mockMvc.perform(delete("/albuns/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNotFound());
    }
}