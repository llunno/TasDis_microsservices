package com.ln.microsservice.bff;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.bff.DTO.EstudanteRegisterReqDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class EstudanteIntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    @Test
    void estudanteRegisterSuccessTest() throws Exception {
        UUID idCursos = UUID.fromString("3f7442df-a11e-4738-8253-30a0c74622b5");
        EstudanteRegisterReqDTO estudante = new EstudanteRegisterReqDTO(
                "João",
                LocalDate.of(2000, 1, 1),
                123456789,
                null,
                "joao@email.com",
                "fakePassword@123",
                "12/@W",
                null,
                List.of(idCursos));

        mockMvc.perform(post("/aluno/novo-estudante")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(estudante)))
                .andExpect(status().isOk());
    }

    @Test
    void obterTodasTarefasPorAlunoNotFOundTest() throws Exception {
        mockMvc.perform(get("/aluno/" + UUID.randomUUID() + "/tarefas")
                .contentType("application/json"))
                .andExpect(status().isNotFound());
    }
}
