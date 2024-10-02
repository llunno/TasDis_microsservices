package com.ln.microsservice.gateway.Presentation;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.gateway.Business.Documentation.ObterTarefasApiDoc;
import com.ln.microsservice.gateway.Business.Documentation.ObterTarefasVencidasApiDoc;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.ln.microsservice.gateway.Business.APiResponses.ApiResponsePattern;
import com.ln.microsservice.gateway.Business.Documentation.NovoAlunoApiDoc;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/aluno")
@Tag(name = "Aluno", description = "Endpoints para o contexto do aluno")
public class AlunoController {

    @Autowired
    private WebClient webClient;

    @ObterTarefasApiDoc
    @GetMapping("/{userId}/tarefas")
    public ResponseEntity<?> getTarefasPendentes(@PathVariable UUID userId) {
        JsonNode response = webClient.get().uri("/aluno/" + userId + "/tarefas").retrieve()
                .bodyToMono(JsonNode.class).block();
        ApiResponsePattern apiResponse = new ApiResponsePattern("Tarefas obtidas com sucesso", response);
        return ResponseEntity.ok(apiResponse);
    }

    @ObterTarefasVencidasApiDoc
    @GetMapping("/{userId}/tarefas-vencidas")
    public ResponseEntity<?> getTarefasVencidas(@PathVariable UUID userId) {
        JsonNode response = webClient.get().uri("/aluno/" + userId + "/tarefas-vencidas").retrieve()
                .bodyToMono(JsonNode.class).block();
        ApiResponsePattern apiResponse = new ApiResponsePattern("Tarefas vencidas obtidas com sucesso", response);
        return ResponseEntity.ok(apiResponse);
    }

    @NovoAlunoApiDoc
    @PostMapping("/novo-estudante")
    public ResponseEntity<?> novoEstudante(@RequestBody JsonNode entity) {
        ApiResponsePattern apiResponse = new ApiResponsePattern("Estudante criado com sucesso");
        Boolean created = webClient.post().uri("/aluno/novo-estudante").bodyValue(entity).retrieve()
                .bodyToMono(Boolean.class).block();
        return created ? ResponseEntity.ok(apiResponse) : ResponseEntity.badRequest().body(apiResponse);
    }

    @GetMapping("/obter-todos-estudantes")
    public ResponseEntity<?> obterTodosEstudantes() {
        JsonNode serializedListEstudantesDTO = webClient.get().uri("/aluno/obter-todos-estudantes").retrieve()
                .bodyToMono(JsonNode.class)
                .block();

        ApiResponsePattern response = new ApiResponsePattern("Estudantes obtidos com sucesso",
                serializedListEstudantesDTO);

        return ResponseEntity.ok(response);
    }
}
