package com.ln.microsservice.gateway.Presentation;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.ln.microsservice.gateway.Business.Documentation.ObterTarefasApiDoc;
import com.ln.microsservice.gateway.Business.Documentation.ObterTarefasVencidasApiDoc;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;

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
        String response = webClient.get().uri("/aluno/" + userId + "/tarefas").retrieve()
                .bodyToMono(String.class).block();
        return ResponseEntity.ok(response);
    }

    @ObterTarefasVencidasApiDoc
    @GetMapping("/{userId}/tarefas-vencidas")
    public ResponseEntity<?> getTarefasVencidas(@PathVariable UUID userId) {
        String response = webClient.get().uri("/aluno/" + userId + "/tarefas-vencidas").retrieve()
                .bodyToMono(String.class).block();
        return ResponseEntity.ok(response);
    }

    @NovoAlunoApiDoc
    @PostMapping("/novo-estudante")
    public ResponseEntity<?> novoEstudante(@RequestBody JsonNode entity) {
        ResponseEntity<?> response = webClient.post().uri("/aluno/novo-estudante").bodyValue(entity).retrieve()
                .bodyToMono(ResponseEntity.class).block();
        return response;
    }
}
