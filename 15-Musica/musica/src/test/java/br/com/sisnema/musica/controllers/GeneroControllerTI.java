package br.com.sisnema.musica.controllers;

import br.com.sisnema.musica.dtos.GeneroDto;
import br.com.sisnema.musica.tests.Factory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class GeneroControllerTI {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Long idExistente;
    private Long idNaoExistente;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeDtos() throws Exception {

        ResultActions resultado = mockMvc.perform(
                get("/generos")
                .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isOk());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmDtoQuandoOIdExistir() throws Exception {
        ResultActions resultado = mockMvc.perform(
                get("/generos/{id}", idExistente)
                .accept(MediaType.APPLICATION_JSON)
        );
        resultado.andExpect(status().isOk()); // HTTP Code 200
    }

    @Test
    public void procurarPorIdDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {
        ResultActions resultado = mockMvc.perform(
                get("/generos/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON)
        );
        resultado.andExpect(status().isNotFound()); // HTTP Code 204
    }

    @Test
    public void inserirDeveriaRetornarUmObjetoDto() throws Exception {

        GeneroDto dto = Factory.criarGeneroDto();
        String jsonBody = objectMapper.writeValueAsString(dto);

        ResultActions resultado = mockMvc.perform(post("/generos")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isCreated()); // HTTP Code 201
    }

    @Test
    public void atualizarDeveriaRetornarUmObjetoDto() throws Exception {

        GeneroDto dto = Factory.criarGeneroDto();
        String jsonBody = objectMapper.writeValueAsString(dto);

        ResultActions resultado = mockMvc.perform(put("/generos/{id}", idExistente)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk());
        resultado.andExpect(jsonPath("$.id").value(idExistente));
        //System.out.println("Dto enviado: " + dto);
    }

    @Test
    public void atualizarDeveriaRetornarUm404IdNãoExistente() throws Exception {

        GeneroDto dto = Factory.criarGeneroDto();
        String jsonBody = objectMapper.writeValueAsString(dto);

        ResultActions resultado = mockMvc.perform(put("/generos/{id}", idNaoExistente)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNotFound());
    }

    @Test
    public void excluirPorIdDeveriaRetornarUm204QuandoOIdExistir() throws Exception {
        ResultActions resultado = mockMvc.perform(
                delete("/generos/{id}", idExistente)
                .accept(MediaType.APPLICATION_JSON)
        );
        resultado.andExpect(status().isNoContent());
    }

    @Test
    public void excluirPorIdDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {
        ResultActions resultado = mockMvc.perform(
                delete("/generos/{id}", idNaoExistente)
                .accept(MediaType.APPLICATION_JSON)
        );
        resultado.andExpect(status().isNotFound());
    }
}
