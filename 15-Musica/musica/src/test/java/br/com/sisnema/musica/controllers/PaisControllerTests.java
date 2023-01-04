package br.com.sisnema.musica.controllers;

import br.com.sisnema.musica.dtos.PaisDto;
import br.com.sisnema.musica.services.PaisService;
import br.com.sisnema.musica.services.exceptions.RecursoNaoEncontrado;
import br.com.sisnema.musica.tests.Factory;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PaisController.class)
public class PaisControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaisService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private PaisDto paisDto;
    private List<PaisDto> paisDtoList;

    @BeforeEach
    void setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 2L;
        idChaveEstrangeira = 3L;
        paisDto = Factory.criarPaisDto();
        paisDtoList = new ArrayList<>();

        when(service.procurarTodos()).thenReturn(paisDtoList);

        when(service.procurarPorId(idExistente)).thenReturn(paisDto);
        when(service.procurarPorId(idNaoExistente)).thenThrow(RecursoNaoEncontrado.class);

        when(service.inserir(any())).thenReturn(paisDto);

        when(service.atualizar(eq(idExistente), any())).thenReturn(paisDto);
        when(service.atualizar(eq(idNaoExistente), any()))
                .thenThrow(RecursoNaoEncontrado.class);

        doNothing().when(service).excluir(idExistente);
        doThrow(RecursoNaoEncontrado.class).when(service).excluir(idNaoExistente);
    }

    @Test
    public void inserirDeveriaRetornarUm201Dto() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(paisDto);

        ResultActions resultado = mockMvc.perform(post("/paises")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isCreated());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.nome").exists());
    }

    @Test
    public void procurarTodosDeveriaRetonarUmaLista() throws Exception {

        ResultActions resultado = mockMvc.perform(get("/paises")
                .accept(MediaType.APPLICATION_JSON));
        resultado.andExpect(status().isOk());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUm200QuandoOIdExistir() throws Exception {

        ResultActions resultado = mockMvc
                        .perform(get("/paises/{id}", idExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.nome").exists());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {

        ResultActions resultado = mockMvc
                .perform(get("/paises/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNotFound());
    }

    @Test
    public void atualizarDeveriaRetornarUm200DtoQuandoOIdExistir() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(paisDto);

        ResultActions resultado = mockMvc
                        .perform(put("/paises/{id}", idExistente)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.nome").exists());
    }

    @Test
    public void atualizarDeveriaRetornarUm404DtoQuandoOIdNaoExistir() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(paisDto);

        ResultActions resultado = mockMvc
                .perform(put("/paises/{id}", idNaoExistente)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNotFound());
    }

    @Test
    public void excluirDeveriaRetornarUm204QuandoOIdExistir() throws Exception {

        ResultActions resultado = mockMvc
                .perform(delete("/paises/{id}", idExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNoContent());
    }

    @Test
    public void excluirDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {

        ResultActions resultado = mockMvc
                .perform(delete("/paises/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNotFound());
    }
}