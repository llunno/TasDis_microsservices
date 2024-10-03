package com.ln.microsservice.gateway.Presentation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.ln.microsservice.gateway.Business.APiResponses.ApiResponsePattern;
import com.ln.microsservice.gateway.Business.Documentation.CriarCursoApiDoc;
import com.ln.microsservice.gateway.Business.Documentation.CriarMateriaApiDoc;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/curso")
@Tag(name = "Curso", description = "Endpoints para o contexto do curso")
public class CursoController {

    @Autowired
    private WebClient webClient;

    @CriarCursoApiDoc
    @PostMapping("/criar")
    public ResponseEntity<?> criarCurso(@RequestBody JsonNode curso) {
        JsonNode response = webClient.post().uri("/curso/criar").bodyValue(curso).retrieve().bodyToMono(JsonNode.class).block();
        ApiResponsePattern apiResponse = new ApiResponsePattern("Curso criado com sucesso", response);
        return ResponseEntity.ok(apiResponse);
    }

    @CriarMateriaApiDoc
    @PostMapping("/criar-materia")
    public ResponseEntity<?> criarMateria(@RequestBody JsonNode materia) {
        JsonNode response = webClient.post().uri("/curso/criar-materia").bodyValue(materia).retrieve().bodyToMono(JsonNode.class).block();
        ApiResponsePattern apiResponse = new ApiResponsePattern("Matéria criada com sucesso", response);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/obter-todos-cursos")
    public ResponseEntity<?> obterTodosCursos() {
        JsonNode response = webClient.get().uri("/curso/obter-todos-cursos").retrieve().bodyToMono(JsonNode.class).block();
        ApiResponsePattern apiResponse = new ApiResponsePattern("Cursos obtidos com sucesso", response);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/obter-todas-materias-por-curso")
    public ResponseEntity<?> obterTodasMateriasPorCurso(@RequestParam UUID cursoId) {
        JsonNode response = webClient.get().uri("/curso/obter-todas-materias-por-curso?cursoId=" + cursoId).retrieve().bodyToMono(JsonNode.class).block();
        ApiResponsePattern apiResponse = new ApiResponsePattern("Matérias obtidas com sucesso", response);
        return ResponseEntity.ok(apiResponse);
    }
}
