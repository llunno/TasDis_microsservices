package com.ln.microsservice.bff;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.bff.DTO.ProfessorRegisterReqDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfessorIntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    @Test
    void criarProfessorSuccessTest() throws JsonProcessingException, Exception {
        UUID instituicaoID = UUID.fromString("3f7442df-a11e-4738-8253-30a0c74622b5");
        ProfessorRegisterReqDTO professor = new ProfessorRegisterReqDTO(
                "Paulo",
                LocalDate.of(2000, 1, 1),
                123456789,
                null,
                "paulo@email.com",
                "fakePassword@123",
                "12/@W",
                null,
                instituicaoID);

        mockMvc.perform(post("/professor/novo-professor")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(professor)))
                .andExpect(status().isOk());

    }
}
