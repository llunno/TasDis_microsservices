package com.ln.microsservice.gateway.Presentation;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/{userId}/tarefas-pendentes")
    public ResponseEntity<?> getTarefasPendentes(@PathVariable UUID userId) {
        String response = webClient.get().uri("/aluno/" + userId + "/tarefas-pendentes").retrieve()
                .bodyToMono(String.class).block();
        return ResponseEntity.ok(response);
    }
}
