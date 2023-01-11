package br.com.sisnema.musica.controllers;

import br.com.sisnema.musica.dtos.EstadoDto;
import br.com.sisnema.musica.services.EstadoService;
import br.com.sisnema.musica.services.exceptions.RecursoNaoEncontrado;
import br.com.sisnema.musica.tests.Factory;
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

@WebMvcTest(EstadoController.class)
public class EstadoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstadoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private EstadoDto estadoDto;
    private List<EstadoDto> estadoDtoList;

    @BeforeEach
    void setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 2L;
        idChaveEstrangeira = 3L;
        estadoDto = Factory.criarEstadoDto();
        estadoDtoList = new ArrayList<>();

        when(service.procurarTodos()).thenReturn(estadoDtoList);

        when(service.procurarPorId(idExistente)).thenReturn(estadoDto);
        when(service.procurarPorId(idNaoExistente)).
                thenThrow(RecursoNaoEncontrado.class);

        when(service.inserir(any())).thenReturn(estadoDto);

        when(service.atualizar(eq(idExistente), any())).thenReturn(estadoDto);
        when(service.atualizar(eq(idNaoExistente), any()))
                .thenThrow(RecursoNaoEncontrado.class);

        doNothing().when(service).excluir(idExistente);
        doThrow(RecursoNaoEncontrado.class).when(service).excluir(idNaoExistente);
    }

    @Test
    public void inserirDeveriaRetornarUm201Dto() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(estadoDto);

        ResultActions resultado = mockMvc.perform(post("/estados")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isCreated());
//        resultado.andExpect(jsonPath("$.id").exists());
//        resultado.andExpect(jsonPath("$.nome").exists());
    }

    @Test
    public void procurarTodosDeveriaRetonarUmaLista() throws Exception {

        ResultActions resultado = mockMvc.perform(get("/estados")
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUm200QuandoOIdExistir() throws Exception {

        ResultActions resultado = mockMvc.perform(get("/estados/{id}", idExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.nome").exists());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {

        ResultActions resultado = mockMvc.perform(get("/estados/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNotFound());
    }

    @Test
    public void atualizarDeveriaRetornarUm200DtoQuandoOIdExistir() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(estadoDto);

        ResultActions resultado = mockMvc.perform(put("/estados/{id}", idExistente)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.nome").exists());
    }

    @Test
    public void atualizarDeveriaRetornarUm404DtoQuandoOIdNaoExistir() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(estadoDto);

        ResultActions resultado = mockMvc.perform(put("/estados/{id}", idNaoExistente)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNotFound());
    }

    @Test
    public void excluirDeveriaRetornarUm204QuandoOIdExistir() throws Exception {

        ResultActions resultado = mockMvc.perform(delete("/estados/{id}", idExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNoContent());
    }

    @Test
    public void excluirDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {

        ResultActions resultado = mockMvc.perform(delete("/estados/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNotFound());
    }
}