package com.ln.microsservice.gateway.Presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.ln.microsservice.gateway.Business.Documentation.CriarTarefaApiDoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private WebClient webClient;

    @CriarTarefaApiDoc
    @PostMapping("/criar-tarefa")
    public ResponseEntity<?> criarTarefa(@RequestBody JsonNode entity) {
        ResponseEntity<?> response = webClient.post()
                .uri("/professor/criar-tarefa")
                .bodyValue(entity)
                .retrieve()
                .bodyToMono(ResponseEntity.class)
                .block();
        return response;
    }
}
