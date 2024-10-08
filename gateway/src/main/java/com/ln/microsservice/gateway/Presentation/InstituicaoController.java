package com.ln.microsservice.gateway.Presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.ln.microsservice.gateway.Business.APiResponses.ApiResponsePattern;
import com.ln.microsservice.gateway.Business.Documentation.CriarInstituicaoApiDoc;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/instituicao")
@Tag(name = "Instituição", description = "Endpoints para o contexto da instituicao")
public class InstituicaoController {

    @Autowired
    private WebClient webClient;

    @CriarInstituicaoApiDoc
    @PostMapping("/criar")
    public ResponseEntity<?> criarInstituicao(@RequestBody JsonNode entity) {
        webClient.post().uri("/instituicao/criar").bodyValue(entity).retrieve()
                .bodyToMono(JsonNode.class).block();
        ApiResponsePattern apiResponsePattern = new ApiResponsePattern("Instituicao criada com sucesso");
        return ResponseEntity.ok(apiResponsePattern);
    }

    @GetMapping("/obter-todas")
    public ResponseEntity<?> obterTodas() {
        JsonNode response = webClient.get().uri("/instituicao/obter-todas").retrieve().bodyToMono(JsonNode.class)
                .block();
        ApiResponsePattern apiResponsePattern = new ApiResponsePattern("Instituicao", response);
        return ResponseEntity.ok(apiResponsePattern);
    }
}
